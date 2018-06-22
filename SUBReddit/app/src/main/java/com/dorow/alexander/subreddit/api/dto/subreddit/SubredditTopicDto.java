package com.dorow.alexander.subreddit.api.dto.subreddit;

import com.google.gson.annotations.SerializedName;

public class SubredditTopicDto {

    @SerializedName("data")
    private TopicDto data;

    public TopicDto getData() {
        return data;
    }

    public void setData(TopicDto data) {
        this.data = data;
    }
}
