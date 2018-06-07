package com.dorow.alexander.subreddit.ui.main;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.di.component.DaggerMainComponent;
import com.dorow.alexander.subreddit.di.module.MainModule;
import com.dorow.alexander.subreddit.ui.base.BaseActivityImpl;

public class MainActivity extends BaseActivityImpl<MainPresenter> implements MainView {


    @Override
    public void onViewReady() {
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
