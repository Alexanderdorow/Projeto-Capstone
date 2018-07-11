package com.dorow.alexander.subreddit.ui.main;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;

import com.dorow.alexander.subreddit.ui.base.BasePresenter;

public interface MainPresenter extends
        BasePresenter,
        SearchView.OnQueryTextListener,
        MenuItem.OnActionExpandListener{

    void onPositiveDialogButtonClick();

    void onNegativeDialogButtonClick();

    void saveState(Bundle outState);

    void restoreData(Bundle savedInstanceState);
}
