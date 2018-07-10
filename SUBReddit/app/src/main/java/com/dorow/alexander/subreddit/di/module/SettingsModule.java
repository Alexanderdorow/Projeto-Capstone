package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.AppConfiguration;
import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.ui.settings.SettingsActivity;
import com.dorow.alexander.subreddit.ui.settings.SettingsPresenter;
import com.dorow.alexander.subreddit.ui.settings.SettingsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsModule {

    private final SettingsActivity context;

    public SettingsModule(SettingsActivity context) {
        this.context = context;
    }

    @Provides
    SettingsActivity providesSettingsContext() {
        return context;
    }

    @Provides
    SettingsPresenter providesMainPresenter(SettingsActivity context, AppDatabase db, AppConfiguration config) {
        return new SettingsPresenterImpl(context, db, config);
    }

}
