package com.dorow.alexander.subreddit.di.module;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.ui.search.SearchPresenter;
import com.dorow.alexander.subreddit.ui.search.SearchPresenterImpl;
import com.dorow.alexander.subreddit.ui.search.SearchView;

import java.security.PublicKey;

import dagger.Module;
import dagger.Provides;

@Module
public class SubredditSearchModule {

    private final SearchView view;
    private final String userSearchQuery;

    public SubredditSearchModule(SearchView view, String userSearchQuery) {
        this.view = view;
        this.userSearchQuery = userSearchQuery;
    }

    @Provides
    public SearchView providesView() {
        return view;
    }

    @Provides
    public String providesUserSearchQuery() {
        return userSearchQuery;
    }

    @Provides
    public SearchPresenter providesPresenter(SearchView view, RedditApi api, String userSearchQuery) {
        return new SearchPresenterImpl(view, userSearchQuery, api);
    }


}
