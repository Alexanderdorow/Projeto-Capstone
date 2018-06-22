package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApiModule;
import com.dorow.alexander.subreddit.di.module.SubredditModule;
import com.dorow.alexander.subreddit.ui.subreddit.SubredditFragment;

import dagger.Component;

@Component(modules = {SubredditModule.class, ApiModule.class})
public interface SubredditComponent {
    void inject(SubredditFragment subredditFragment);
}
