package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApplicationModule;
import com.dorow.alexander.subreddit.di.module.DatabaseModule;
import com.dorow.alexander.subreddit.di.module.SubredditAggregationModule;
import com.dorow.alexander.subreddit.ui.aggregation.AggregationFragment;

import dagger.Component;

@Component(modules = {SubredditAggregationModule.class, DatabaseModule.class, ApplicationModule.class})
public interface SubredditAggregationComponent {

    void inject(AggregationFragment aggregationFragment);
}
