package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApiModule;
import com.dorow.alexander.subreddit.di.module.SubredditSearchModule;
import com.dorow.alexander.subreddit.ui.search.SearchFragment;

import dagger.Component;

@Component(modules = {SubredditSearchModule.class, ApiModule.class})
public interface SubredditSearchComponent {

    void inject(SearchFragment searchFragment);
}
