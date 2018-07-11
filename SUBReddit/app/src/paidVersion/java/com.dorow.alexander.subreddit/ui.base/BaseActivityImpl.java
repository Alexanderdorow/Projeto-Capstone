package com.dorow.alexander.subreddit.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import javax.inject.Inject;

public abstract class BaseActivityImpl<P extends BasePresenter, DB extends ViewDataBinding> extends AppCompatActivity implements BaseView {

    @Inject
    protected P presenter;
    protected DB dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getContentView());
        onViewReady(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenuView() != 0) {
            getMenuInflater().inflate(getMenuView(), menu);
        }
        beforeCreateMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void beforeCreateMenu(Menu menu) {

    }


    protected abstract int getMenuView();

    @LayoutRes
    protected abstract int getContentView();


}
