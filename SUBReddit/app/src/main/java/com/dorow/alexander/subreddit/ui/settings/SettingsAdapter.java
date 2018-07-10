package com.dorow.alexander.subreddit.ui.settings;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dorow.alexander.subreddit.database.model.FavoriteSubreddit;
import com.dorow.alexander.subreddit.databinding.ItemSettingFavoriteBinding;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.ArrayList;
import java.util.List;

class SettingsAdapter extends RecyclerView.Adapter<SettingsViewHolder> {

    private List<FavoriteSubreddit> favoriteSubreddits = new ArrayList<>();
    private AdapterItemClickCallback<FavoriteSubreddit> callback;

    @NonNull
    @Override
    public SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSettingFavoriteBinding binding = ItemSettingFavoriteBinding.inflate(layoutInflater, parent, false);
        return new SettingsViewHolder(binding, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsViewHolder holder, int position) {
        holder.bind(favoriteSubreddits.get(position));
    }

    @Override
    public int getItemCount() {
        return favoriteSubreddits.size();
    }

    void addItems(List<FavoriteSubreddit> items) {
        favoriteSubreddits.addAll(items);
        notifyDataSetChanged();
    }

    public void setCallback(AdapterItemClickCallback<FavoriteSubreddit> callback) {
        this.callback = callback;
    }

    void removeItem(FavoriteSubreddit item) {
        this.favoriteSubreddits.remove(item);
        notifyDataSetChanged();
    }
}
