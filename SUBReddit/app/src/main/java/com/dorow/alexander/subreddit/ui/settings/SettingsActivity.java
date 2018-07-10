package com.dorow.alexander.subreddit.ui.settings;

import android.view.MenuItem;
import android.widget.Toast;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.databinding.ActivitySettingsBinding;
import com.dorow.alexander.subreddit.di.component.DaggerSettingsComponent;
import com.dorow.alexander.subreddit.di.module.SettingsModule;
import com.dorow.alexander.subreddit.ui.base.BaseActivityImpl;

import java.util.List;

public class SettingsActivity extends BaseActivityImpl<SettingsPresenter, ActivitySettingsBinding> implements SettingsView {

    private SettingsAdapter adapter;

    @Override
    public void onViewReady() {
        adapter = new SettingsAdapter();
        DaggerSettingsComponent.builder().settingsModule(new SettingsModule(this)).build().inject(this);
        adapter.setCallback(presenter);
        setSupportActionBar(dataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        dataBinding.wifiSyncSwitch.setOnCheckedChangeListener(presenter);
        dataBinding.favoriteSubredditsList.setAdapter(adapter);
    }

    @Override
    protected int getMenuView() {
        return 0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_settings;
    }

    @Override
    public void setOnlyWifiSwitchActive(boolean onlyWifiSync) {
        dataBinding.wifiSyncSwitch.setChecked(onlyWifiSync);
    }

    @Override
    public void setItemsOnAdapter(List<FavoriteSubreddit> all) {
        adapter.addItems(all);
    }

    @Override
    public void displayRemovedToast() {
        Toast.makeText(this, R.string.subreddit_removed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void removeFromAdapter(FavoriteSubreddit item) {
        adapter.removeItem(item);
    }
}
