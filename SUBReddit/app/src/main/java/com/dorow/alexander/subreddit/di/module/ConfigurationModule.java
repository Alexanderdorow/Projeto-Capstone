package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.AppApplication;
import com.dorow.alexander.subreddit.AppConfiguration;

import dagger.Module;
import dagger.Provides;

@Module
public class ConfigurationModule {

    @Provides
    AppConfiguration providesAppDatabase(AppApplication appApplicationContext) {
        return AppConfiguration.getInstance(appApplicationContext);
    }

}
