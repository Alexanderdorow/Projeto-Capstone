package com.dorow.alexander.subreddit.ui.search;

import android.os.Bundle;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.api.dto.search.RedditSearchResponse;
import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchDto;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenterImpl extends BasePresenterImpl<SearchView> implements SearchPresenter, Callback<RedditSearchResponse> {

    private static final String SAVED_STATE_USER_QUERY = "SAVED_STATE_USER_QUERY";
    private static final String SAVED_STATE_ITEMS = "SAVED_STATE_ITEMS";
    private String userSearchQuery;
    private final RedditApi api;

    public SearchPresenterImpl(SearchView view, String userSearchQuery, RedditApi api) {
        super(view);
        this.userSearchQuery = userSearchQuery;
        this.api = api;
    }


    @Override
    public void onResponse(Call<RedditSearchResponse> call, Response<RedditSearchResponse> response) {
        if (!response.isSuccessful()) {
            return;
        }
        List<SubredditSearchData> dataList = new ArrayList<>();
        if (response.body() != null) {
            for (SubredditSearchDto subredditSearchDto : response.body().getData().getChildren()) {
                dataList.add(subredditSearchDto.getData());
            }
        }

        view.setItemsOnAdapter(dataList);
    }

    @Override
    public void onFailure(Call<RedditSearchResponse> call, Throwable t) {

    }

    @Override
    public void onSaveInstance(Bundle outState, List<SubredditSearchData> items) {
        outState.putString(SAVED_STATE_USER_QUERY, userSearchQuery);
        outState.putSerializable(SAVED_STATE_ITEMS, new ArrayList<>(items));
    }

    @Override
    public void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            api.search(userSearchQuery).enqueue(this);
        } else {
            userSearchQuery = savedInstanceState.getString(SAVED_STATE_USER_QUERY);
            view.setItemsOnAdapter((List<SubredditSearchData>) savedInstanceState.getSerializable(SAVED_STATE_ITEMS));
        }
    }
}
