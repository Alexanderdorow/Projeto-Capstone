package com.dorow.alexander.subreddit.ui.search;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.api.dto.search.RedditSearchResponse;
import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchDto;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPresenterImpl extends BasePresenterImpl<SearchView> implements SearchPresenter, Callback<RedditSearchResponse> {

    public SearchPresenterImpl(SearchView view, String userSearchQuery, RedditApi api) {
        super(view);
        api.search(userSearchQuery).enqueue(this);
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
}
