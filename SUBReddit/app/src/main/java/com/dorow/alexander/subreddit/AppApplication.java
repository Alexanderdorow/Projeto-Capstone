package com.dorow.alexander.subreddit;

import android.app.Application;
import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;

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

    public static void logEvent(String event, Context context) {
        if (AppConfiguration.getInstance(context).canLogEvent())
            FirebaseAnalytics.getInstance(context).logEvent(event, null);
    }
}
