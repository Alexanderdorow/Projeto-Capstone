package com.dorow.alexander.subreddit.ui.main;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;


public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    public MainPresenterImpl(MainView view, RedditApi api) {
        super(view);
    }

}
