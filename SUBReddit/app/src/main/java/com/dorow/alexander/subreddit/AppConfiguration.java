package com.dorow.alexander.subreddit;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfiguration {

    private static final String SP_NAME = "SUB_REDDIT_SHARED_PREFERENCES";
    private static final String SHARED_PREFERENCE_KEY_ONLY_NETWORK = "SHARED_PREFERENCE_KEY_ONLY_NETWORK";
    private static final String SHARED_PREFERENCE_KEY_CAN_LOG_EVENT = "SHARED_PREFERENCE_KEY_CAN_LOG_EVENT";
    private static final String SHARED_PREFERENCE_KEY_SHOW_INIT_DIALOG = "SHARED_PREFERENCE_KEY_SHOW_INIT_DIALOG";
    private static AppConfiguration INSTANCE;
    private final Context context;

    private AppConfiguration(Context context) {
        this.context = context;
    }

    public static AppConfiguration getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AppConfiguration(context);
        }
        return INSTANCE;
    }

    private SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public void setOnlyWifiSync(boolean setOnlyWifiSync) {
        getSharedPreferences()
                .edit()
                .putBoolean(SHARED_PREFERENCE_KEY_ONLY_NETWORK, setOnlyWifiSync)
                .apply();
    }

    public boolean onlyWifiSync() {
        return getSharedPreferences().getBoolean(SHARED_PREFERENCE_KEY_ONLY_NETWORK, false);
    }

    public boolean needsShowInitialDialog() {
        return getSharedPreferences().getBoolean(SHARED_PREFERENCE_KEY_SHOW_INIT_DIALOG, true);
    }

    public void setNeedsShowInitialDialog(boolean needs) {
        getSharedPreferences()
                .edit()
                .putBoolean(SHARED_PREFERENCE_KEY_SHOW_INIT_DIALOG, needs)
                .apply();
    }

    public void setCanLogEvent(boolean canLogEvent) {
        getSharedPreferences()
                .edit()
                .putBoolean(SHARED_PREFERENCE_KEY_CAN_LOG_EVENT, canLogEvent)
                .apply();
    }

    boolean canLogEvent() {
        return getSharedPreferences().getBoolean(SHARED_PREFERENCE_KEY_CAN_LOG_EVENT, false);
    }
}
