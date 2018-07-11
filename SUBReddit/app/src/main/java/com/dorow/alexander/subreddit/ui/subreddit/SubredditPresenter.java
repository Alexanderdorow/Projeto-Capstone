package com.dorow.alexander.subreddit.ui.subreddit;

import android.os.Bundle;

import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.ui.base.BasePresenter;

import java.util.List;

public interface SubredditPresenter extends BasePresenter {

    void loadMore();

    void onItemSelected(TopicDto item);

    void saveOnFavoriteSubOnDatabase(boolean save);

    void saveInstanceState(Bundle outState, List<TopicDto> items);

    void retrieveData(Bundle savedInstanceState);
}
