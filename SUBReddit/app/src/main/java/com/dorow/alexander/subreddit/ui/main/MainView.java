package com.dorow.alexander.subreddit.ui.main;

import com.dorow.alexander.subreddit.ui.base.BaseView;

public interface MainView extends BaseView {
    void inflateSearchFragment(String text);

    void inflateMainFragment();

    void inflateSubredditFragment(String subreddit);
}
