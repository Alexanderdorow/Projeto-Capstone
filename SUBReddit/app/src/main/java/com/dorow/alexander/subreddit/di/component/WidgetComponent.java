package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApplicationModule;
import com.dorow.alexander.subreddit.di.module.ConfigurationModule;
import com.dorow.alexander.subreddit.di.module.DatabaseModule;
import com.dorow.alexander.subreddit.di.module.MainModule;
import com.dorow.alexander.subreddit.ui.main.MainActivity;
import com.dorow.alexander.subreddit.ui.widget.WidgetDataProvider;

import dagger.Component;

@Component(modules = {DatabaseModule.class, ApplicationModule.class})
public interface WidgetComponent {

    void inject(WidgetDataProvider service);

}
