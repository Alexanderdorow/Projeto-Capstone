package com.dorow.alexander.subreddit.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.dorow.alexander.subreddit.AppConfiguration;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;


public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    public static final String SAVED_INSTANCE_QUERY_TEXT = "SAVED_INSTANCE_QUERY_TEXT";
    public static final String SAVED_INSTANCE_FILTER_OPEN = "SAVED_INSTANCE_FILTER_OPEN";
    private final AppConfiguration config;
    private String queryText;
    private boolean filterOpen;

    public MainPresenterImpl(MainView view, AppConfiguration config) {
        super(view);
        this.view.initJobDispatcher(config.onlyWifiSync());
        this.view.inflateMainFragment(false);
        this.config = config;
        verifyLogPermissions();
    }

    private void verifyLogPermissions() {
        if (config.needsShowInitialDialog()) {
            view.showsDialog();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        view.inflateSearchFragment(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        queryText = newText;
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        filterOpen = true;
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        filterOpen = false;
        view.inflateMainFragment(false);
        return true;
    }

    @Override
    public void onPositiveDialogButtonClick() {
        config.setNeedsShowInitialDialog(false);
        config.setCanLogEvent(true);
    }

    @Override
    public void onNegativeDialogButtonClick() {
        config.setNeedsShowInitialDialog(false);
        config.setCanLogEvent(false);
    }

    @Override
    public void saveState(Bundle outState) {
        outState.putString(SAVED_INSTANCE_QUERY_TEXT, queryText);
        outState.putBoolean(SAVED_INSTANCE_FILTER_OPEN, filterOpen);

    }
}
