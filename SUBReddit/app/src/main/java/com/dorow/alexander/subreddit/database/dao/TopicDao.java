package com.dorow.alexander.subreddit.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.database.model.Topic;

import java.util.List;

@Dao
public interface TopicDao {

    @Query("SELECT * FROM topics")
    List<Topic> findAll();

    @Query("SELECT * FROM topics WHERE title = :title AND name = :name AND thumbnail = :thumbnail AND subreddit_name_prefixed = :subredditPrefix")
    Topic findOne(String title, String name, String thumbnail, String subredditPrefix);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Topic subreddit);

    @Query("DELETE FROM topics WHERE subreddit_name_prefixed = :subredditPrefix")
    void remove(String subredditPrefix);

    @Query("SELECT COUNT(*) FROM topics")
    int count();
}
