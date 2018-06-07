package com.dorow.alexander.subreddit.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public abstract class BaseActivityImpl<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        onViewReady();
    }

    @LayoutRes
    protected abstract int getContentView();


}
