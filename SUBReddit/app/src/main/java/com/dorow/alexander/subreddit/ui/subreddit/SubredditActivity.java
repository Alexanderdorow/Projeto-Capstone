package com.dorow.alexander.subreddit.ui.subreddit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.dorow.alexander.subreddit.AppApplication;
import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;
import com.dorow.alexander.subreddit.databinding.ActivitySubredditBinding;
import com.dorow.alexander.subreddit.di.component.DaggerSubredditComponent;
import com.dorow.alexander.subreddit.di.module.SubredditModule;
import com.dorow.alexander.subreddit.ui.base.BaseActivityImpl;
import com.dorow.alexander.subreddit.ui.component.EndlessRecyclerOnScrollListener;
import com.dorow.alexander.subreddit.ui.topic.TopicActivity;
import com.dorow.alexander.subreddit.util.AdapterItemClickCallback;

import java.util.List;

public class SubredditActivity extends BaseActivityImpl<SubredditPresenter, ActivitySubredditBinding>
        implements SubredditView, AdapterItemClickCallback<TopicDto> {

    private SubredditAdapter adapter;
    public final static String SELECTED_SUBREDDIT = "SELECTED_SUBREDDIT";

    @Override
    public void onViewReady(Bundle savedInstanceState) {
        String subredditSelected = getIntent().getStringExtra(SELECTED_SUBREDDIT);
        DaggerSubredditComponent.builder()
                .subredditModule(new SubredditModule(this, subredditSelected))
                .build()
                .inject(this);
        setSupportActionBar(dataBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(subredditSelected);
        adapter = new SubredditAdapter(this);
        dataBinding.subredditList.setLayoutManager(new LinearLayoutManager(this));
        dataBinding.subredditList.setAdapter(adapter);
        if (savedInstanceState != null)
            presenter.retrieveData(savedInstanceState);
        dataBinding.subredditList.addOnScrollListener(new EndlessRecyclerOnScrollListener((LinearLayoutManager) dataBinding.subredditList.getLayoutManager()) {
            @Override
            public void onLoadMore() {
                presenter.loadMore();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        presenter.saveInstanceState(outState, adapter.getItems());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppApplication.logEvent("in_main_activity", this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                item.setChecked(!item.isChecked());
                item.setIcon(item.isChecked() ? R.drawable.ic_star_enabled : R.drawable.ic_star_disabled);
                presenter.saveOnFavoriteSubOnDatabase(item.isChecked());
                Toast.makeText(this, item.isChecked() ? R.string.sub_saved : R.string.sub_unsaved, Toast.LENGTH_LONG).show();
                break;
            default:
                onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int getMenuView() {
        return R.menu.subreddit_menu;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_subreddit;
    }

    @Override
    public void addItemsOnAdapter(List<TopicDto> dataList) {
        adapter.addItems(dataList);
    }

    @Override
    public void openTopicActivity(String selectedSubreddit, String id) {
        Intent i = new Intent(this, TopicActivity.class);
        i.putExtra(SELECTED_SUBREDDIT, selectedSubreddit);
        i.putExtra(TopicActivity.SUBREDDIT_ID, id);
        startActivity(i);
    }

    @Override
    public void onItemClick(TopicDto item) {
        presenter.onItemSelected(item);
    }
}
