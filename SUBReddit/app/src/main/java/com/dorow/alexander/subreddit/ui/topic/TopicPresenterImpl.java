package com.dorow.alexander.subreddit.ui.topic;

import com.dorow.alexander.subreddit.BuildConfig;
import com.dorow.alexander.subreddit.ui.base.BasePresenterImpl;

import java.util.Locale;

public class TopicPresenterImpl extends BasePresenterImpl<TopicView> implements TopicPresenter {

    private final static String THREAD_URL_FORMAT = "%s/r/%s/%s";

    public TopicPresenterImpl(TopicView view, String topicId, String subrredit) {
        super(view);
        view.setDataOnView(String.format(Locale.getDefault(), THREAD_URL_FORMAT, BuildConfig.SERVER_URL, subrredit.replace("r/", ""), topicId));
    }
}
