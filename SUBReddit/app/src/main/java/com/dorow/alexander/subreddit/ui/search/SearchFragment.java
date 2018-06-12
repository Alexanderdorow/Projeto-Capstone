package com.dorow.alexander.subreddit.ui.search;

import android.view.View;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.api.dto.SubredditSearchDto;
import com.dorow.alexander.subreddit.databinding.FragmentSubredditSearchBinding;
import com.dorow.alexander.subreddit.di.component.DaggerSubredditSearchComponent;
import com.dorow.alexander.subreddit.di.module.SubredditSearchModule;
import com.dorow.alexander.subreddit.ui.base.BaseFragmentImpl;

import java.util.List;

public class SearchFragment extends BaseFragmentImpl<SearchPresenter, FragmentSubredditSearchBinding> implements SearchView {

    public static final String SEARCH_TEXT = "SEARCH_TEXT";
    private SearchAdapter adapter;

    @Override
    public void onViewReady() {
        adapter = new SearchAdapter();
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
    public void setItemsOnAdapter(List<SubredditSearchDto.SubredditSearchData> dataList) {
//        dataBinding.
        dataBinding.progressLoading.setVisibility(View.GONE);
        adapter.setItems(dataList);
    }
}
