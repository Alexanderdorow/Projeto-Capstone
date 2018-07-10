package com.dorow.alexander.subreddit;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfiguration {

    private static final String SP_NAME = "SUB_REDDIT_SHARED_PREFERENCES";
    private static final String SHARED_PREFERENCE_KEY_ONLY_NETWORK = "SHARED_PREFERENCE_KEY_ONLY_NETWORK";
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
}
