package com.dorow.alexander.subreddit.ui.settings;

import android.widget.CompoundButton;

import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.ui.base.BasePresenter;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

public interface SettingsPresenter extends BasePresenter, CompoundButton.OnCheckedChangeListener, AdapterItemClickCallback<FavoriteSubreddit> {

}
