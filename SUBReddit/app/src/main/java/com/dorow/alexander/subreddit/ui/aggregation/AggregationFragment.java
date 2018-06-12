package com.dorow.alexander.subreddit.ui.aggregation;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.databinding.FragmentAggregatedSubredditsBinding;
import com.dorow.alexander.subreddit.di.component.DaggerSubredditAggregationComponent;
import com.dorow.alexander.subreddit.di.module.SubredditAggregationModule;
import com.dorow.alexander.subreddit.ui.base.BaseFragmentImpl;

public class AggregationFragment extends BaseFragmentImpl<AggregationPresenter, FragmentAggregatedSubredditsBinding>
        implements AggregationView {



    @Override
    public void onViewReady() {
        DaggerSubredditAggregationComponent.builder().subredditAggregationModule(new SubredditAggregationModule(this)).build().inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_aggregated_subreddits;
    }
}
