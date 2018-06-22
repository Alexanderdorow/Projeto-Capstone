package com.dorow.alexander.subreddit.api.dto.subreddit;

import com.google.gson.annotations.SerializedName;

public class TopicDto {

    @SerializedName("author")
    private String author;
    @SerializedName("name")
    private String name;
    @SerializedName("title")
    private String title;
    @SerializedName("thumbnail")
    private String thumbnail;

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
}
