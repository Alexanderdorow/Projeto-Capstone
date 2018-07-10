package com.dorow.alexander.subreddit.ui.aggregation;

import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.ui.base.BaseView;

import java.util.List;

public interface AggregationView extends BaseView {
    void addItemsOnView(List<Topic> topics);

    void showLoading();

    void hideLoading();

    void openTopicActivity(String selectedSubreddit, String id);
}
