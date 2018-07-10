package com.dorow.alexander.subreddit.ui.aggregation;

import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.ui.base.BasePresenter;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

public interface AggregationPresenter extends BasePresenter, AdapterItemClickCallback<Topic> {
    void unregisterObserver();

    void loadMore();

}
