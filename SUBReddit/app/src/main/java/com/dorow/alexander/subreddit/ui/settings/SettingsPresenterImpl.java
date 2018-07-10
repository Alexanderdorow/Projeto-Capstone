package com.dorow.alexander.subreddit.ui.settings;

import android.widget.CompoundButton;

import com.dorow.alexander.subreddit.AppConfiguration;
import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;

public class SettingsPresenterImpl extends BasePresenterImpl<SettingsView> implements SettingsPresenter {

    private final AppDatabase db;
    private final AppConfiguration configuration;

    public SettingsPresenterImpl(SettingsView view, AppDatabase db, AppConfiguration configuration) {
        super(view);
        this.db = db;
        this.configuration = configuration;
        setupView();
    }

    private void setupView() {
        view.setOnlyWifiSwitchActive(configuration.onlyWifiSync());
        view.setItemsOnAdapter(db.favoriteSubredditDao().findAll());
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        configuration.setOnlyWifiSync(isChecked);
    }

    @Override
    public void onItemClick(FavoriteSubreddit item) {
        view.displayRemovedToast();
        view.removeFromAdapter(item);
        db.favoriteSubredditDao().remove(item.getSubredditPrefix());
        db.topicDao().remove("r/" + item.getSubredditPrefix());
    }
}
