package com.dorow.alexander.subreddit.api.dto.subreddit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubredditResponse {

    @SerializedName("dist")
    private int dist;
    @SerializedName("children")
    private List<SubredditTopicDto> children;
    @SerializedName("after")
    private String after;

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public List<SubredditTopicDto> getChildren() {
        return children;
    }

    public void setChildren(List<SubredditTopicDto> children) {
        this.children = children;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
