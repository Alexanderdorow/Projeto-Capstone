package com.dorow.alexander.subreddit.util;

import android.os.AsyncTask;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.api.dto.subreddit.RedditSubredditResponse;
import com.dorow.alexander.subreddit.api.dto.subreddit.SubredditResponse;
import com.dorow.alexander.subreddit.api.dto.subreddit.SubredditTopicDto;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.database.dao.TopicDao;
import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.di.component.DaggerSyncJobComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class SyncTask extends AsyncTask<Void, Void, Void> {

    @Inject
    AppDatabase db;

    @Inject
    RedditApi api;

    public SyncTask() {
        DaggerSyncJobComponent.builder().build().inject(this);
    }

    @Override
    protected Void doInBackground(Void... voids) {
            for (FavoriteSubreddit favoriteSubreddit : db.favoriteSubredditDao().findAll()) {
            Call<RedditSubredditResponse> subredditData = api.getSubredditData(favoriteSubreddit.getSubredditPrefix(),
                    favoriteSubreddit.getCount(), favoriteSubreddit.getAfter(), 10);
            try {
                Response<RedditSubredditResponse> execute = subredditData.execute();
                if (!execute.isSuccessful()) {
                    continue;
                }
                SubredditResponse body = execute.body().getData();
                List<SubredditTopicDto> children = body.getChildren();
                favoriteSubreddit.setAfter(body.getAfter());
                favoriteSubreddit.setCount(body.getDist());
                db.favoriteSubredditDao().insert(favoriteSubreddit);
                List<Topic> topics = new ArrayList<>();
                TopicDao topicDao = db.topicDao();
                for (SubredditTopicDto child : children) {
                    TopicDto data = child.getData();
                    Topic topic = topicDao.findOne(data.getTitle(), data.getName(), data.getThumbnail(), data.getSubredditPrefix());
                    if (topic == null) {
                        topic = new Topic(data);
                    }
                    topicDao.insert(topic);
                    topics.add(topic);
                }
                SyncObservable.getInstance().setTopics(topics);
            } catch (IOException ignored) {
                return null;
            }
        }
        return null;
    }
}
