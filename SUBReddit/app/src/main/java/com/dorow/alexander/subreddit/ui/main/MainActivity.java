package com.dorow.alexander.subreddit.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.databinding.ActivityMainBinding;
import com.dorow.alexander.subreddit.di.component.DaggerMainComponent;
import com.dorow.alexander.subreddit.di.module.MainModule;
import com.dorow.alexander.subreddit.ui.base.BaseActivityImpl;
import com.dorow.alexander.subreddit.ui.search.SearchFragment;
import com.dorow.alexander.subreddit.ui.aggregation.AggregationFragment;

import java.util.List;

public class MainActivity extends BaseActivityImpl<MainPresenter, ActivityMainBinding> implements MainView {
    @Override
    public void onViewReady() {
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);
        setSupportActionBar(dataBinding.toolbar);
        inflateMainFragment();
    }

    @Override
    public void beforeCreateMenu(Menu menu) {
        MenuItem mSearch = menu.findItem(R.id.search);
        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setOnQueryTextListener(presenter);
        mSearch.setOnActionExpandListener(presenter);
    }

    @Override
    protected int getMenuView() {
        return R.menu.main_menu;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void inflateSearchFragment(String text) {
        SearchFragment fragment = new SearchFragment();
        Bundle b = new Bundle();
        b.putString(SearchFragment.SEARCH_TEXT,text);
        fragment.setArguments(b);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rootView, fragment, fragment.getClass().getName())
                .commit();
    }

    @Override
    public void inflateMainFragment() {
        AggregationFragment fragment = new AggregationFragment();
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments.size() > 0 && fragments.get(0).getTag().equals(AggregationFragment.class.getName())) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rootView, fragment, fragment.getClass().getName())
                .commit();
    }
}
