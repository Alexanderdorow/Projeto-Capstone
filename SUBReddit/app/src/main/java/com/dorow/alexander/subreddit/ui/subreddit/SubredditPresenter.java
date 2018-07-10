package com.dorow.alexander.subreddit.ui.subreddit;

import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.ui.base.BasePresenter;

public interface SubredditPresenter extends BasePresenter {

    void loadMore();

    void onItemSelected(TopicDto item);

    void saveOnFavoriteSubOnDatabase(boolean save);
}
