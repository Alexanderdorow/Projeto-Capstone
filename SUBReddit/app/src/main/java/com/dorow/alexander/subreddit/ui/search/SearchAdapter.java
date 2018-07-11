package com.dorow.alexander.subreddit.ui.search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.databinding.ItemSearchBinding;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private List<SubredditSearchData> data = new ArrayList<>();
    private AdapterItemClickCallback<SubredditSearchData> callback;

    public SearchAdapter(AdapterItemClickCallback<SubredditSearchData> callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemSearchBinding itemBinding = ItemSearchBinding.inflate(layoutInflater, parent, false);
        return new SearchViewHolder(itemBinding, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void setItems(List<SubredditSearchData> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public List<SubredditSearchData> getItems() {
        return data;
    }
}
