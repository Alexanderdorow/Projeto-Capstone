package com.dorow.alexander.subreddit.ui.search;

import android.view.View;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.databinding.FragmentSubredditSearchBinding;
import com.dorow.alexander.subreddit.di.component.DaggerSubredditSearchComponent;
import com.dorow.alexander.subreddit.di.module.SubredditSearchModule;
import com.dorow.alexander.subreddit.ui.base.BaseFragmentImpl;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.List;

public class SearchFragment extends BaseFragmentImpl<SearchPresenter, FragmentSubredditSearchBinding> implements SearchView, AdapterItemClickCallback<SubredditSearchData> {

    public static final String SEARCH_TEXT = "SEARCH_TEXT";
    private SearchAdapter adapter;

    @Override
    public void onViewReady() {
        adapter = new SearchAdapter(this);
        dataBinding.searchList.setAdapter(adapter);
        DaggerSubredditSearchComponent.builder()
                .subredditSearchModule(new SubredditSearchModule(this, getArguments().getString(SEARCH_TEXT)))
                .build()
                .inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_subreddit_search;
    }

    @Override
    public void setItemsOnAdapter(List<SubredditSearchData> dataList) {
        dataBinding.progressLoading.setVisibility(View.GONE);
        adapter.setItems(dataList);
    }

    @Override
    public void onItemClick(SubredditSearchData item) {
        activityContext.openSubredditActivity(item.getSubredditPrefix());
    }
}
