package com.dorow.alexander.subreddit.ui.subreddit;

import android.os.Bundle;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.api.dto.subreddit.RedditSubredditResponse;
import com.dorow.alexander.subreddit.api.dto.subreddit.SubredditResponse;
import com.dorow.alexander.subreddit.api.dto.subreddit.SubredditTopicDto;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubredditPresenterImpl extends BasePresenterImpl<SubredditView> implements SubredditPresenter, Callback<RedditSubredditResponse> {

    private static final String SAVED_INSTANCE_DIST = "SAVED_INSTANCE_DIST";
    private static final String SAVED_INSTANCE_AFTER = "SAVED_INSTANCE_AFTER";
    private static final String SAVED_INSTANCE_ITEMS = "SAVED_INSTANCE_ITEMS";
    private final RedditApi api;
    private final String selectedSubreddit;
    private final AppDatabase db;
    private String after;
    private int dist;

    public SubredditPresenterImpl(SubredditView view, RedditApi api, AppDatabase db, String selectedSubreddit) {
        super(view);
        this.api = api;
        this.db = db;
        this.selectedSubreddit = selectedSubreddit.replace("r/", "");
        loadMore();
    }

    @Override
    public void onResponse(Call<RedditSubredditResponse> call, Response<RedditSubredditResponse> response) {
        if (!response.isSuccessful()) {
            return;
        }
        SubredditResponse data = response.body().getData();
        after = data.getAfter();
        dist = data.getDist();
        List<TopicDto> children = new ArrayList<>();
        for (SubredditTopicDto child : data.getChildren()) {
            children.add(child.getData());
        }
        view.addItemsOnAdapter(children);
    }

    @Override
    public void onFailure(Call<RedditSubredditResponse> call, Throwable t) {

    }

    @Override
    public void loadMore() {
        api.getSubredditData(selectedSubreddit, dist, after, 10).enqueue(this);
    }

    @Override
    public void onItemSelected(TopicDto item) {
        view.openTopicActivity(selectedSubreddit, item.getId());
    }

    @Override
    public void saveOnFavoriteSubOnDatabase(boolean save) {
        if (save) {
            db.favoriteSubredditDao().insert(new FavoriteSubreddit(selectedSubreddit));
        } else {
            db.favoriteSubredditDao().remove(selectedSubreddit);
        }
    }

    @Override
    public void saveInstanceState(Bundle outState, List<TopicDto> items) {
        outState.putInt(SAVED_INSTANCE_DIST, dist);
        outState.putString(SAVED_INSTANCE_AFTER, after);
        outState.putSerializable(SAVED_INSTANCE_ITEMS, new ArrayList<>(items));
    }

    @Override
    public void retrieveData(Bundle savedInstanceState) {
        dist = savedInstanceState.getInt(SAVED_INSTANCE_DIST);
        after = savedInstanceState.getString(SAVED_INSTANCE_AFTER);
        List<TopicDto> topicDtos = (List<TopicDto>) savedInstanceState.getSerializable(SAVED_INSTANCE_ITEMS);
        view.addItemsOnAdapter(topicDtos);
    }
}
