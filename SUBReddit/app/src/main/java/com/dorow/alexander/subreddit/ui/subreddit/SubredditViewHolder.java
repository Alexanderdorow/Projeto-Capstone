package com.dorow.alexander.subreddit.ui.subreddit;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.databinding.ItemSubredditBinding;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

class SubredditViewHolder extends RecyclerView.ViewHolder {

    private final ItemSubredditBinding binding;
    private final AdapterItemClickCallback<TopicDto> callback;

    public SubredditViewHolder(ItemSubredditBinding binding, AdapterItemClickCallback<TopicDto> callback) {
        super(binding.getRoot());
        this.binding = binding;
        this.callback = callback;
    }

    public void bind(final TopicDto data) {
        binding.topicAuthor.setText(data.getAuthor());
        binding.subredditTitle.setText(data.getSubredditPrefix());
        binding.title.setText(data.getTitle());
        Glide.with(binding.getRoot()).load(data.getThumbnail()).apply(new RequestOptions().centerCrop()).into(binding.thumbnail);
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    callback.onItemClick(data);
                }
        });
    }
}
