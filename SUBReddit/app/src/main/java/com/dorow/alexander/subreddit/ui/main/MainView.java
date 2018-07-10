package com.dorow.alexander.subreddit.ui.main;

import com.dorow.alexander.subreddit.ui.base.BaseView;

public interface MainView extends BaseView {
    void inflateSearchFragment(String text);

    void inflateMainFragment(boolean force);

    void openSubredditActivity(String subreddit);

    void initJobDispatcher(boolean onlyWifiSync);

    void showsDialog();
}
