package com.dorow.alexander.subreddit.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import com.dorow.alexander.subreddit.AppConfiguration;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;


public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    public static final String SAVED_INSTANCE_QUERY_TEXT = "SAVED_INSTANCE_QUERY_TEXT";
    public static final String SAVED_INSTANCE_FILTER_OPEN = "SAVED_INSTANCE_FILTER_OPEN";
    private static final String SAVED_INSTANCE_SCREEN_ROTATED = "SAVED_INSTANCE_SCREEN_ROTATED";
    private final AppConfiguration config;
    private String queryText;
    private boolean filterOpen;
    private boolean screenRotated;

    public MainPresenterImpl(MainView view, AppConfiguration config) {
        super(view);
        this.view.initJobDispatcher(config.onlyWifiSync());
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
        if (screenRotated) {
            screenRotated = false;
            return false;
        }
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
        screenRotated = true;
        outState.putString(SAVED_INSTANCE_QUERY_TEXT, queryText);
        outState.putBoolean(SAVED_INSTANCE_FILTER_OPEN, filterOpen);
        outState.putBoolean(SAVED_INSTANCE_SCREEN_ROTATED, true);
    }

    @Override
    public void restoreData(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.view.inflateMainFragment(false);
        } else {
            screenRotated = savedInstanceState.getBoolean(SAVED_INSTANCE_SCREEN_ROTATED, false);
        }
    }
}
