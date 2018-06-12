package com.dorow.alexander.subreddit.ui.main;

import com.dorow.alexander.subreddit.ui.base.BaseView;

interface MainView extends BaseView {
    void inflateSearchFragment(String text);

    void inflateMainFragment();
}
