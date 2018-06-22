package com.dorow.alexander.subreddit.ui.subreddit;

import android.support.v7.widget.LinearLayoutManager;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.databinding.FragmentSubredditBinding;
import com.dorow.alexander.subreddit.di.component.DaggerSubredditComponent;
import com.dorow.alexander.subreddit.di.module.SubredditModule;
import com.dorow.alexander.subreddit.ui.base.BaseFragmentImpl;
import com.dorow.alexander.subreddit.ui.component.EndlessRecyclerOnScrollListener;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.List;

public class SubredditFragment extends BaseFragmentImpl<SubredditPresenter, FragmentSubredditBinding>
        implements SubredditView, AdapterItemClickCallback<TopicDto> {

    private SubredditAdapter adapter;
    public final static String SELECTED_SUBREDDIT = "SELECTED_SUBREDDIT";

    @Override
    public void onViewReady() {
        adapter = new SubredditAdapter(this);
        DaggerSubredditComponent.builder()
                .subredditModule(new SubredditModule(this, getArguments().getString(SELECTED_SUBREDDIT)))
                .build()
                .inject(this);
        dataBinding.subredditList.setAdapter(adapter);
        dataBinding.subredditList.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) dataBinding.subredditList.getLayoutManager()) {
            @Override
            public void onLoadMore() {
                presenter.loadMore();
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_subreddit;
    }

    @Override
    public void addItemsOnAdapter(List<TopicDto> dataList) {
        adapter.addItems(dataList);
    }

    @Override
    public void onItemClick(TopicDto item) {
    }
}
