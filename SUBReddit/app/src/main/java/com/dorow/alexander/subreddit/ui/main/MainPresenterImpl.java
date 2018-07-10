package com.dorow.alexander.subreddit.ui.main;

import android.content.DialogInterface;
import android.util.Log;
import android.view.MenuItem;

import com.dorow.alexander.subreddit.AppConfiguration;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;


public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    private final AppConfiguration config;

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
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
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
}
