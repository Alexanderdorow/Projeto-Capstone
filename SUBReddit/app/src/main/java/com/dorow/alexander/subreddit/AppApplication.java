package com.dorow.alexander.subreddit;

import android.app.Application;

public class AppApplication extends Application {

    private static AppApplication INSTANCE;

    public static AppApplication getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
