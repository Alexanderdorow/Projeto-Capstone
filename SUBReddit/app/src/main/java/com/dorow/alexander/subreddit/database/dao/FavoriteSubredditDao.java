package com.dorow.alexander.subreddit.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;

import java.util.List;
import java.util.Observable;

@Dao
public interface FavoriteSubredditDao {

    @Query("SELECT * FROM favorites")
    List<FavoriteSubreddit> findAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FavoriteSubreddit subreddit);

    @Query("DELETE FROM favorites WHERE subreddit_prefix = :subredditPrefix")
    void remove(String subredditPrefix);
}
