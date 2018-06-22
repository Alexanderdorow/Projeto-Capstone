package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.ui.aggregation.AggregationPresenter;
import com.dorow.alexander.subreddit.ui.aggregation.AggregationPresenterImpl;
import com.dorow.alexander.subreddit.ui.aggregation.AggregationView;

import dagger.Module;
import dagger.Provides;

@Module
public class SubredditAggregationModule {

    private final AggregationView view;

    public SubredditAggregationModule(AggregationView view) {
        this.view = view;
    }

    @Provides
    public AggregationView providesView() {
        return view;
    }

    @Provides
    public AggregationPresenter providesPresenter(AggregationView view) {
        return new AggregationPresenterImpl(view);
    }

}
