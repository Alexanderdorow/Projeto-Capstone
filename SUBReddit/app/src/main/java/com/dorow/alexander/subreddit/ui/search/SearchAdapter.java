package com.dorow.alexander.subreddit.ui.search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dorow.alexander.subreddit.api.dto.SubredditSearchDto;
import com.dorow.alexander.subreddit.databinding.ItemSearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    List<SubredditSearchDto.SubredditSearchData> data = new ArrayList<>();

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ItemSearchBinding itemBinding =
                ItemSearchBinding.inflate(layoutInflater, parent, false);
        return new SearchViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<SubredditSearchDto.SubredditSearchData> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
