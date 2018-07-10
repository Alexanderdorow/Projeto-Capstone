package com.dorow.alexander.subreddit.api.dto.subreddit;

import com.google.gson.annotations.SerializedName;

public class TopicDto {

    @SerializedName("id")
    private String id;
    @SerializedName("author")
    private String author;
    @SerializedName("name")
    private String name;
    @SerializedName("title")
    private String title;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("subreddit_name_prefixed")
    private String subredditPrefix;

    public String getSubredditPrefix() {
        return subredditPrefix;
    }

    public void setSubredditPrefix(String subredditPrefix) {
        this.subredditPrefix = subredditPrefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
