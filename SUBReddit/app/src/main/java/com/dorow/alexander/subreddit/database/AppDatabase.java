package com.dorow.alexander.subreddit.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dorow.alexander.subreddit.database.dao.FavoriteSubredditDao;
import com.dorow.alexander.subreddit.database.dao.TopicDao;
import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.database.model.Topic;

@Database(entities = {FavoriteSubreddit.class, Topic.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract FavoriteSubredditDao favoriteSubredditDao();

    public abstract TopicDao topicDao();


}
