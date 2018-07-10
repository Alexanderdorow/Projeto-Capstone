package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApplicationModule;
import com.dorow.alexander.subreddit.di.module.ConfigurationModule;
import com.dorow.alexander.subreddit.di.module.MainModule;
import com.dorow.alexander.subreddit.ui.main.MainActivity;

import dagger.Component;

@Component(modules = {MainModule.class, ConfigurationModule.class, ApplicationModule.class})
public interface MainComponent {

    void inject(MainActivity activity);

}
