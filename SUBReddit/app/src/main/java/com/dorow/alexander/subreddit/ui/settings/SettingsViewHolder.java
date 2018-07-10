package com.dorow.alexander.subreddit.ui.settings;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.databinding.ItemSettingFavoriteBinding;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

class SettingsViewHolder extends RecyclerView.ViewHolder {

    private final ItemSettingFavoriteBinding binding;
    private final AdapterItemClickCallback<FavoriteSubreddit> callback;

    SettingsViewHolder(ItemSettingFavoriteBinding binding, AdapterItemClickCallback<FavoriteSubreddit> callback) {
        super(binding.getRoot());
        this.binding = binding;
        this.callback = callback;
    }

    public void bind(final FavoriteSubreddit subreddit) {
        binding.setSubreddit(subreddit);
        binding.removeSubreddit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClick(subreddit);
            }
        });
    }
}
