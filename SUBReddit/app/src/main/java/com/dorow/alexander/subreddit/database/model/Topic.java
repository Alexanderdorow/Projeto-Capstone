package com.dorow.alexander.subreddit.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "topics")
public class Topic implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "author")
    private String author;
    @ColumnInfo(name = "threadId")
    private String threadId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "thumbnail")
    private String thumbnail;
    @ColumnInfo(name = "subreddit_name_prefixed")
    private String subredditPrefix;

    public Topic(int id, String threadId, String author, String name, String title, String thumbnail, String subredditPrefix) {
        this.id = id;
        this.threadId = threadId;
        this.author = author;
        this.name = name;
        this.title = title;
        this.thumbnail = thumbnail;
        this.subredditPrefix = subredditPrefix;
    }

    @Ignore
    public Topic(TopicDto data) {
        this.threadId = data.getId();
        this.author = data.getAuthor();
        this.name = data.getName();
        this.title = data.getTitle();
        this.thumbnail = data.getThumbnail();
        this.subredditPrefix = data.getSubredditPrefix();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
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

    public String getSubredditPrefix() {
        return subredditPrefix;
    }

    public void setSubredditPrefix(String subredditPrefix) {
        this.subredditPrefix = subredditPrefix;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Topic)) {
            return false;
        }

        Topic topic = (Topic) o;

        return topic.name.equals(name) &&
                topic.subredditPrefix.equals(subredditPrefix) &&
                topic.title.equals(title);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + subredditPrefix.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

}