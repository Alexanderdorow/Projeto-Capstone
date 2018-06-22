package com.dorow.alexander.subreddit.ui.search;

import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchDto;
import com.dorow.alexander.subreddit.ui.base.BaseView;

import java.util.List;

public interface SearchView extends BaseView {
    void setItemsOnAdapter(List<SubredditSearchData> dataList);
}
