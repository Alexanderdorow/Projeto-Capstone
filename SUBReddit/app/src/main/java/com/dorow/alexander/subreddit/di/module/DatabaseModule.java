package com.dorow.alexander.subreddit.di.module;

import android.arch.persistence.room.Room;

import com.dorow.alexander.subreddit.AppApplication;
import com.dorow.alexander.subreddit.database.AppDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    AppDatabase providesAppDatabase(AppApplication appApplicationContext) {
        return Room.databaseBuilder(appApplicationContext,
                AppDatabase.class, "subreddit.db")
                .allowMainThreadQueries()
                .build();
    }

}
