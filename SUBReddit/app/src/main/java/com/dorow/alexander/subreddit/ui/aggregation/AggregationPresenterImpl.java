package com.dorow.alexander.subreddit.ui.aggregation;

import android.os.Bundle;

import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;
import com.dorow.alexander.subreddit.util.SyncObservable;
import com.dorow.alexander.subreddit.util.SyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AggregationPresenterImpl extends BasePresenterImpl<AggregationView> implements AggregationPresenter, Observer {

    private static final String SAVED_INSTANCE_ITEMS = "SAVED_INSTANCE_ITEMS";
    private final AppDatabase db;

    public AggregationPresenterImpl(AggregationView view, AppDatabase db) {
        super(view);
        SyncObservable.getInstance().addObserver(this);
        this.db = db;
        if (db.favoriteSubredditDao().findAll().size() > 0) {
            new SyncTask().execute();
            this.view.showLoading();
        }
    }

    @Override
    public void unregisterObserver() {
        SyncObservable.getInstance().deleteObserver(this);
    }

    @Override
    public void loadMore() {
        new SyncTask().execute();
    }

    @Override
    public void saveInstanceState(Bundle outState, ArrayList<Topic> items) {
        outState.putSerializable(SAVED_INSTANCE_ITEMS, new ArrayList<>(items));
    }

    @Override
    public void retrieveData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            List<Topic> topics = (List<Topic>) savedInstanceState.getSerializable(SAVED_INSTANCE_ITEMS);
            if (topics.size() > 0) {
                this.view.hideLoading();
                this.view.addItemsOnView(topics);
            }
        } else {
            List<Topic> all = db.topicDao().findAll();
            if (all.size() > 0) {
                this.view.hideLoading();
                this.view.addItemsOnView(all);
            }
        }
    }

    @Override
    public void onItemClick(Topic item) {
        view.openTopicActivity(item.getSubredditPrefix(), item.getThreadId());
    }

    @Override
    public void update(Observable o, Object arg) {
        SyncObservable syncObservable = (SyncObservable) o;
        if (syncObservable.getTopics() != null) {
            this.view.hideLoading();
            view.addItemsOnView(syncObservable.getTopics());
        }
    }
}
