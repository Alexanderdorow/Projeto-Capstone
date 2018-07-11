package com.dorow.alexander.subreddit.ui.subreddit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.databinding.ItemSubredditBinding;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.ArrayList;
import java.util.List;

public class SubredditAdapter extends RecyclerView.Adapter<SubredditViewHolder> {

    private final AdapterItemClickCallback<TopicDto> callback;
    private List<TopicDto> data = new ArrayList<>();

    public SubredditAdapter(AdapterItemClickCallback<TopicDto> callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public SubredditViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSubredditBinding itemBinding = ItemSubredditBinding.inflate(layoutInflater, parent, false);
        return new SubredditViewHolder(itemBinding, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull SubredditViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItems(List<TopicDto> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public List<TopicDto> getItems() {
        return this.data;
    }
}
