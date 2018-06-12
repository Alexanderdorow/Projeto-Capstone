package com.dorow.alexander.subreddit.ui.search;

import com.dorow.alexander.subreddit.api.dto.SubredditSearchDto;
import com.dorow.alexander.subreddit.ui.base.BaseView;

import java.util.List;

public interface SearchView extends BaseView {
    void setItemsOnAdapter(List<SubredditSearchDto.SubredditSearchData> dataList);
}
