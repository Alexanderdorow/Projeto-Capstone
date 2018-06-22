package com.dorow.alexander.subreddit.api.dto.subreddit;

import com.google.gson.annotations.SerializedName;

public class RedditSubredditResponse {

    @SerializedName("data")
    private SubredditResponse data;

    public SubredditResponse getData() {
        return data;
    }

    public void setData(SubredditResponse data) {
        this.data = data;
    }
}
