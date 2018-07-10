package com.dorow.alexander.subreddit.ui.settings;

import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.ui.base.BaseView;

import java.util.List;

public interface SettingsView extends BaseView {
    void setOnlyWifiSwitchActive(boolean onlyWifiSync);

    void setItemsOnAdapter(List<FavoriteSubreddit> all);

    void displayRemovedToast();

    void removeFromAdapter(FavoriteSubreddit item);
}
