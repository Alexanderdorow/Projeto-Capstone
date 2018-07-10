package com.dorow.alexander.subreddit.ui.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.dorow.alexander.subreddit.AppApplication;
import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.databinding.ActivityMainBinding;
import com.dorow.alexander.subreddit.di.component.DaggerMainComponent;
import com.dorow.alexander.subreddit.di.module.MainModule;
import com.dorow.alexander.subreddit.ui.aggregation.AggregationFragment;
import com.dorow.alexander.subreddit.ui.base.BaseActivityImpl;
import com.dorow.alexander.subreddit.ui.search.SearchFragment;
import com.dorow.alexander.subreddit.ui.settings.SettingsActivity;
import com.dorow.alexander.subreddit.ui.subreddit.SubredditActivity;
import com.dorow.alexander.subreddit.util.SyncJobService;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends BaseActivityImpl<MainPresenter, ActivityMainBinding> implements MainView {

    public static final int WINDOW_START = 1800;
    public static final int WINDOW_END = 3600;
    public static final String JOB_TAG = "location-update-job";
    public static final String WIDGET_TOPIC_EXTRA = "WIDGET_TOPIC_EXTRA";

    @Override
    public void onViewReady() {
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);
        setSupportActionBar(dataBinding.toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        inflateMainFragment(true);
        AppApplication.logEvent("in_main_activity", this);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.config:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openSubredditActivity(String subreddit) {
        Intent i = new Intent(this, SubredditActivity.class);
        i.putExtra(SubredditActivity.SELECTED_SUBREDDIT, subreddit);
        startActivity(i);
    }

    @Override
    public void initJobDispatcher(boolean onlyWifiSync) {
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        Job myJob = dispatcher.newJobBuilder()
                .setService(SyncJobService.class)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(WINDOW_START, WINDOW_END))
                .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR)
                .setTag(JOB_TAG)
                .setRecurring(true)
                .setConstraints(onlyWifiSync ? Constraint.ON_UNMETERED_NETWORK : Constraint.ON_ANY_NETWORK)
                .setLifetime(Lifetime.FOREVER)
                .build();
        dispatcher.mustSchedule(myJob);
    }

    @Override
    public void showsDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_log_title)
                .setMessage(R.string.dialog_log_message)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.onPositiveDialogButtonClick();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.onNegativeDialogButtonClick();
                    }
                })
                .create();
        alertDialog.show();
    }

    @Override
    public void inflateSearchFragment(String text) {
        SearchFragment fragment = new SearchFragment();
        Bundle b = new Bundle();
        b.putString(SearchFragment.SEARCH_TEXT, text);
        fragment.setArguments(b);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rootView, fragment, fragment.getClass().getName())
                .commit();
    }

    @Override
    public void inflateMainFragment(boolean force) {
        AggregationFragment fragment = new AggregationFragment();
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (!force && fragments.size() > 0 && fragments.get(0).getTag().equals(AggregationFragment.class.getName())) {
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable(WIDGET_TOPIC_EXTRA, getIntent().getSerializableExtra(WIDGET_TOPIC_EXTRA));
        fragment.setArguments(bundle);
        getIntent().putExtra(WIDGET_TOPIC_EXTRA, (Serializable) null);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rootView, fragment, fragment.getClass().getName())
                .commit();
    }
}
