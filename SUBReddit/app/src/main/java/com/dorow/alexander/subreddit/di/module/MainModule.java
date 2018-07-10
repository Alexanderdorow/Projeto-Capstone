package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.AppConfiguration;
import com.dorow.alexander.subreddit.ui.main.MainActivity;
import com.dorow.alexander.subreddit.ui.main.MainPresenter;
import com.dorow.alexander.subreddit.ui.main.MainPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainActivity context;

    public MainModule(MainActivity context) {
        this.context = context;
    }

    @Provides
    MainActivity providesMainContext() {
        return context;
    }

    @Provides
    MainPresenter providesMainPresenter(MainActivity context, AppConfiguration configuration) {
        return new MainPresenterImpl(context, configuration);
    }

}
