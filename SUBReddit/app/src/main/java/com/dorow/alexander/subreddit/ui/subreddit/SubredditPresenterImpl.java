package com.dorow.alexander.subreddit.ui.subreddit;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.api.dto.subreddit.RedditSubredditResponse;
import com.dorow.alexander.subreddit.api.dto.subreddit.SubredditResponse;
import com.dorow.alexander.subreddit.api.dto.subreddit.SubredditTopicDto;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubredditPresenterImpl extends BasePresenterImpl<SubredditView> implements SubredditPresenter, Callback<RedditSubredditResponse> {

    private final RedditApi api;
    private final String selectedSubreddit;
    private String after;
    private int dist;

    public SubredditPresenterImpl(SubredditView view, RedditApi api, String selectedSubreddit) {
        super(view);
        this.api = api;
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
}
