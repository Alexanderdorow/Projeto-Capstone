package com.dorow.alexander.subreddit.di.component;

import com.dorow.alexander.subreddit.di.module.ApiModule;
import com.dorow.alexander.subreddit.di.module.ApplicationModule;
import com.dorow.alexander.subreddit.di.module.ConfigurationModule;
import com.dorow.alexander.subreddit.di.module.MainModule;
import com.dorow.alexander.subreddit.di.module.TopicModule;
import com.dorow.alexander.subreddit.ui.main.MainActivity;
import com.dorow.alexander.subreddit.ui.topic.TopicActivity;

import dagger.Component;

@Component(modules = {TopicModule.class, ApiModule.class, ConfigurationModule.class, ApplicationModule.class})
public interface TopicComponent {

    void inject(TopicActivity activity);

}
