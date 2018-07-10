package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApplicationModule;
import com.dorow.alexander.subreddit.di.module.ConfigurationModule;
import com.dorow.alexander.subreddit.di.module.DatabaseModule;
import com.dorow.alexander.subreddit.di.module.SettingsModule;
import com.dorow.alexander.subreddit.ui.main.MainActivity;
import com.dorow.alexander.subreddit.ui.settings.SettingsActivity;

import dagger.Component;

@Component(modules = {SettingsModule.class, DatabaseModule.class, ConfigurationModule.class, ApplicationModule.class})
public interface SettingsComponent {

    void inject(SettingsActivity activity);

}
