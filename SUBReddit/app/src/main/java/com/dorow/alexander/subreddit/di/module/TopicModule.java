package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.ui.topic.TopicPresenter;
import com.dorow.alexander.subreddit.ui.topic.TopicPresenterImpl;
import com.dorow.alexander.subreddit.ui.topic.TopicView;

import dagger.Module;
import dagger.Provides;

@Module
public class TopicModule {
    private final TopicView view;
    private final String topicId;
    private final String subrredit;

    public TopicModule(TopicView view, String topicId, String subrredit) {
        this.view = view;
        this.topicId = topicId;
        this.subrredit = subrredit;
    }

    @Provides
    public TopicView providesView() {
        return view;
    }

    @Provides
    public TopicPresenter providesPresenter(TopicView view) {
        return new TopicPresenterImpl(view, topicId, subrredit);
    }

}
