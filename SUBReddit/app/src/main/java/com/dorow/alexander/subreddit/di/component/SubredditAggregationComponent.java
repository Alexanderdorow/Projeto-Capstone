package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.SubredditAggregationModule;
import com.dorow.alexander.subreddit.ui.aggregation.AggregationFragment;

import dagger.Component;

@Component(modules = {SubredditAggregationModule.class})
public interface SubredditAggregationComponent {

    void inject(AggregationFragment aggregationFragment);
}
