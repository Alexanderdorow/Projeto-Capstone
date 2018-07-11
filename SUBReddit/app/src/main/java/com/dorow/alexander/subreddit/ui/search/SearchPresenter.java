package com.dorow.alexander.subreddit.ui.search;

import android.os.Bundle;

import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.ui.base.BasePresenter;

import java.util.List;

public interface SearchPresenter extends BasePresenter {

    void onSaveInstance(Bundle outState, List<SubredditSearchData> items);

    void restoreState(Bundle savedInstanceState);
}
