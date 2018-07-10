package com.dorow.alexander.subreddit.api;

import com.dorow.alexander.subreddit.api.dto.RedditThreadResponse;
import com.dorow.alexander.subreddit.api.dto.search.RedditSearchResponse;
import com.dorow.alexander.subreddit.api.dto.subreddit.RedditSubredditResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditApi {

    @GET("subreddits/search.json")
    Call<RedditSearchResponse> search(@Query("q") String search);

    @GET("/r/{path}.json")
    Call<RedditSubredditResponse> getSubredditData(@Path("path") String subReddit, @Query("count") int count, @Query("after") String after, @Query("limit") int limit);

    @GET("/r/{path}/{topic}.json")
    Call<List<RedditThreadResponse>> getTopicData(@Path("path") String subrredit, @Path("topic") String topicId);
}
