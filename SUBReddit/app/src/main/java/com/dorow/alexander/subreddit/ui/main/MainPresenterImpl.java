package com.dorow.alexander.subreddit.ui.main;

import android.view.MenuItem;

import com.dorow.alexander.subreddit.api.RedditApi;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;


public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    public MainPresenterImpl(MainView view, RedditApi api) {
        super(view);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        view.inflateSearchFragment(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {

        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        view.inflateMainFragment();
        return true;
    }
}
