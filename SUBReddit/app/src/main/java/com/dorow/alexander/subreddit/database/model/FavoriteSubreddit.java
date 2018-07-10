package com.dorow.alexander.subreddit.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "favorites")
public class FavoriteSubreddit {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "subreddit_prefix")
    private String subredditPrefix;

    @ColumnInfo(name = "count")
    private int count;

    @ColumnInfo(name = "after")
    private String after;

    @Ignore
    public FavoriteSubreddit() {

    }

    @Ignore
    public FavoriteSubreddit(String subredditPrefix) {
        this.subredditPrefix = subredditPrefix;
    }

    public FavoriteSubreddit(int id, String subredditPrefix) {
        this.id = id;
        this.subredditPrefix = subredditPrefix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubredditPrefix() {
        return subredditPrefix;
    }

    public void setSubredditPrefix(String subredditPrefix) {
        this.subredditPrefix = subredditPrefix;
    }

    public String getAfter() {
        return after;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
