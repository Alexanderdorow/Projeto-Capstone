package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApiModule;
import com.dorow.alexander.subreddit.di.module.ApplicationModule;
import com.dorow.alexander.subreddit.di.module.ConfigurationModule;
import com.dorow.alexander.subreddit.di.module.DatabaseModule;
import com.dorow.alexander.subreddit.di.module.SubredditModule;
import com.dorow.alexander.subreddit.ui.subreddit.SubredditActivity;

import dagger.Component;

@Component(modules = {SubredditModule.class, ApiModule.class, DatabaseModule.class, ConfigurationModule.class, ApplicationModule.class})
public interface SubredditComponent {
    void inject(SubredditActivity subredditActivity);
}
