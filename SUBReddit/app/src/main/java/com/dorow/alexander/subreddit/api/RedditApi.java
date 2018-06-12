package com.dorow.alexander.subreddit.api;

import com.dorow.alexander.subreddit.api.dto.RedditSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RedditApi {

    @GET("subreddits/search.json")
    Call<RedditSearchResponse> search(@Query("q") String search);

}
