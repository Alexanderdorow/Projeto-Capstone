package com.dorow.alexander.subreddit.ui.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.databinding.ItemSearchBinding;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

class SearchViewHolder extends RecyclerView.ViewHolder {

    private final ItemSearchBinding binding;
    private final AdapterItemClickCallback<SubredditSearchData> callback;

    public SearchViewHolder(final ItemSearchBinding binding, final AdapterItemClickCallback<SubredditSearchData> callback) {
        super(binding.getRoot());
        this.binding = binding;
        this.callback = callback;
    }

    public void bind(final SubredditSearchData data) {
        this.binding.setSubreddit(data);
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onItemClick(data);
            }
        });
    }
}
