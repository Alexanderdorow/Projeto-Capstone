package com.dorow.alexander.subreddit.ui.aggregation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.databinding.FragmentAggregatedSubredditsBinding;
import com.dorow.alexander.subreddit.di.component.DaggerSubredditAggregationComponent;
import com.dorow.alexander.subreddit.di.module.SubredditAggregationModule;
import com.dorow.alexander.subreddit.ui.base.BaseFragmentImpl;
import com.dorow.alexander.subreddit.ui.component.EndlessRecyclerOnScrollListener;
import com.dorow.alexander.subreddit.ui.topic.TopicActivity;

import java.util.List;

import static com.dorow.alexander.subreddit.ui.main.MainActivity.WIDGET_TOPIC_EXTRA;
import static com.dorow.alexander.subreddit.ui.subreddit.SubredditActivity.SELECTED_SUBREDDIT;

public class AggregationFragment extends BaseFragmentImpl<AggregationPresenter, FragmentAggregatedSubredditsBinding>
        implements AggregationView {

    private AggregationAdapter adapter;

    @Override
    public void onViewReady(Bundle savedInstanceState) {
        adapter = new AggregationAdapter();
        DaggerSubredditAggregationComponent.builder().subredditAggregationModule(new SubredditAggregationModule(this)).build().inject(this);
        adapter.setCallback(presenter);
        dataBinding.subredditNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
        dataBinding.subredditNewsList.setAdapter(adapter);
        dataBinding.subredditNewsList.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) dataBinding.subredditNewsList.getLayoutManager()) {
            @Override
            public void onLoadMore() {
                presenter.loadMore();
            }
        });
        if (getArguments() != null && getArguments().getSerializable(WIDGET_TOPIC_EXTRA) != null) {
            Topic topic = (Topic) getArguments().getSerializable(WIDGET_TOPIC_EXTRA);
            presenter.onItemClick(topic);
        }
        presenter.retrieveData(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        presenter.saveInstanceState(outState, adapter.getItems());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        presenter.unregisterObserver();
        super.onDestroy();
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_aggregated_subreddits;
    }

    @Override
    public void addItemsOnView(final List<Topic> topics) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.addItems(topics);
            }
        });
    }

    @Override
    public void showLoading() {
        hideFields();
        dataBinding.progressLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideFields();
                dataBinding.progressLoading.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void openTopicActivity(String selectedSubreddit, String id) {
        Intent i = new Intent(getContext(), TopicActivity.class);
        i.putExtra(SELECTED_SUBREDDIT, selectedSubreddit);
        i.putExtra(TopicActivity.SUBREDDIT_ID, id);
        startActivity(i);
    }

    private void hideFields() {
        dataBinding.noSubredditImage.setVisibility(View.GONE);
        dataBinding.noSubredditMessage.setVisibility(View.GONE);
        dataBinding.noSubredditTitle.setVisibility(View.GONE);
    }
}
