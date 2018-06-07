package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApiModule;
import com.dorow.alexander.subreddit.di.module.MainModule;
import com.dorow.alexander.subreddit.ui.main.MainActivity;

import dagger.Component;

@Component(modules = {MainModule.class, ApiModule.class})
public interface MainComponent {

    void inject(MainActivity activity);

}
