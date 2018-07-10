package com.dorow.alexander.subreddit.ui.topic;

import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.databinding.ActivityTopicBinding;
import com.dorow.alexander.subreddit.di.component.DaggerTopicComponent;
import com.dorow.alexander.subreddit.di.module.TopicModule;
import com.dorow.alexander.subreddit.ui.base.BaseActivityImpl;
import com.dorow.alexander.subreddit.ui.subreddit.SubredditActivity;

public class TopicActivity extends BaseActivityImpl<TopicPresenter, ActivityTopicBinding> implements TopicView {

    public static final String SUBREDDIT_ID = "SUBREDDIT_ID";

    @Override
    public void onViewReady() {
        DaggerTopicComponent.builder().topicModule(new TopicModule(this,
                getIntent().getStringExtra(SUBREDDIT_ID),
                getIntent().getStringExtra(SubredditActivity.SELECTED_SUBREDDIT)
        )).build().inject(this);
        setSupportActionBar(dataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected int getMenuView() {
        return 0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_topic;
    }

    @Override
    public void setDataOnView(String requestUrl) {
        WebSettings webSettings = dataBinding.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        dataBinding.webView.setWebViewClient(new WebViewClient());
        dataBinding.webView.loadUrl(requestUrl);
    }
}
