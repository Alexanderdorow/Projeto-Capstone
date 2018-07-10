package com.dorow.alexander.subreddit.ui.aggregation;

import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;
import com.dorow.alexander.subreddit.util.SyncObservable;
import com.dorow.alexander.subreddit.util.SyncTask;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AggregationPresenterImpl extends BasePresenterImpl<AggregationView> implements AggregationPresenter, Observer {

    public AggregationPresenterImpl(AggregationView view, AppDatabase db) {
        super(view);
        SyncObservable.getInstance().addObserver(this);
        if (db.favoriteSubredditDao().findAll().size() > 0) {
            new SyncTask().execute();
            this.view.showLoading();
        }
        List<Topic> all = db.topicDao().findAll();
        if (all.size() > 0) {
            this.view.hideLoading();
            this.view.addItemsOnView(all);
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
