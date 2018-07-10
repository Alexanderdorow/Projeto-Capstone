package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApiModule;
import com.dorow.alexander.subreddit.di.module.ApplicationModule;
import com.dorow.alexander.subreddit.di.module.DatabaseModule;
import com.dorow.alexander.subreddit.util.SyncTask;

import dagger.Component;

@Component(modules = {ApiModule.class, DatabaseModule.class, ApplicationModule.class})
public interface SyncJobComponent {

    void inject(SyncTask service);

}
