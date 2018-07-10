package com.dorow.alexander.subreddit.ui.main;

import android.content.DialogInterface;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;

import com.dorow.alexander.subreddit.ui.base.BasePresenter;

public interface MainPresenter extends
        BasePresenter,
        SearchView.OnQueryTextListener,
        MenuItem.OnActionExpandListener{

    void onPositiveDialogButtonClick();

    void onNegativeDialogButtonClick();
}
