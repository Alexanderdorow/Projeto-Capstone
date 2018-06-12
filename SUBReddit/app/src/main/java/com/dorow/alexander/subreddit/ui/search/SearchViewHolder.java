package com.dorow.alexander.subreddit.ui.search;

import android.support.v7.widget.RecyclerView;

import com.dorow.alexander.subreddit.api.dto.SubredditSearchDto;
import com.dorow.alexander.subreddit.databinding.ItemSearchBinding;

class SearchViewHolder extends RecyclerView.ViewHolder {

    private final ItemSearchBinding binding;

    public SearchViewHolder(ItemSearchBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(SubredditSearchDto.SubredditSearchData data) {
        this.binding.setSubreddit(data);
    }
}
