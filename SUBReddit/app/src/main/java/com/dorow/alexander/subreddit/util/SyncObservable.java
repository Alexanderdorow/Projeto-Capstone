package com.dorow.alexander.subreddit.util;

import com.dorow.alexander.subreddit.database.model.Topic;

import java.util.List;
import java.util.Observable;

public class SyncObservable extends Observable {

    private List<Topic> topics;
    private static SyncObservable INSTANCE;

    private SyncObservable() {

    }

    public static SyncObservable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SyncObservable();
        }

        return INSTANCE;
    }

    void setTopics(List<Topic> topics) {
        this.topics = topics;
        setChanged();
        notifyObservers();
    }

    public List<Topic> getTopics() {
        return topics;
    }
}
