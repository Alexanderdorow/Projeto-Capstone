package com.dorow.alexander.subreddit.ui.subreddit;

import com.dorow.alexander.subreddit.api.dto.search.SubredditSearchData;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.ui.base.BaseView;

import java.util.List;

public interface SubredditView extends BaseView {
    void addItemsOnAdapter(List<TopicDto> dataList);
}
