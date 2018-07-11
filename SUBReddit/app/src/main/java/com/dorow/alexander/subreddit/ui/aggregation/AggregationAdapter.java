package com.dorow.alexander.subreddit.ui.aggregation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.databinding.ItemSubredditBinding;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AggregationAdapter extends RecyclerView.Adapter<AggregationViewHolder> {

    private AdapterItemClickCallback<Topic> callback;
    private Set<Topic> data = new HashSet<>();

    public AggregationAdapter() {
        this.callback = callback;
    }

    @NonNull
    @Override
    public AggregationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSubredditBinding itemBinding = ItemSubredditBinding.inflate(layoutInflater, parent, false);
        return new AggregationViewHolder(itemBinding, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull AggregationViewHolder holder, int position) {
        holder.bind(data.toArray(new Topic[0])[position]);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItems(List<Topic> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setCallback(AdapterItemClickCallback<Topic> callback) {
        this.callback = callback;
    }

    public ArrayList<Topic> getItems() {
        return new ArrayList<>(this.data);
    }
}
