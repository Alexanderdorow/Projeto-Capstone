package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.AppApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    AppApplication providesAppApplicationContext() {
        return AppApplication.getInstance();
    }

}
