package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.ui.search.SearchPresenter;
import com.dorow.alexander.subreddit.ui.search.SearchPresenterImpl;
import com.dorow.alexander.subreddit.ui.search.SearchView;
import com.dorow.alexander.subreddit.ui.subreddit.SubredditPresenter;
import com.dorow.alexander.subreddit.ui.subreddit.SubredditPresenterImpl;
import com.dorow.alexander.subreddit.ui.subreddit.SubredditView;

import dagger.Module;
import dagger.Provides;

@Module
public class SubredditModule {

    private final SubredditView view;
    private final String selectedSubreddit;

    public SubredditModule(SubredditView view, String selectedSubreddit) {
        this.view = view;
        this.selectedSubreddit = selectedSubreddit;
    }

    @Provides
    public SubredditView providesView() {
        return view;
    }

    @Provides
    public String providesSelectedSubreddit() {
        return selectedSubreddit;
    }

    @Provides
    public SubredditPresenter providesPresenter(SubredditView view, RedditApi api, AppDatabase db, String selectedSubreddit) {
        return new SubredditPresenterImpl(view, api, db, selectedSubreddit);
    }


}
