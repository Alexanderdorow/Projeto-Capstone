package com.dorow.alexander.subreddit.ui.aggregation;

import android.os.Bundle;

import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.ui.base.BasePresenter;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.ArrayList;

public interface AggregationPresenter extends BasePresenter, AdapterItemClickCallback<Topic> {
    void unregisterObserver();

    void loadMore();

    void saveInstanceState(Bundle outState, ArrayList<Topic> items);

    void retrieveData(Bundle savedInstanceState);
}
