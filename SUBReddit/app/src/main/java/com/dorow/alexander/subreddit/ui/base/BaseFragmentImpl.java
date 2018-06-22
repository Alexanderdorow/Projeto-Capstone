package com.dorow.alexander.subreddit.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dorow.alexander.subreddit.ui.main.MainActivity;
import com.dorow.alexander.subreddit.ui.main.MainView;

import javax.inject.Inject;

public abstract class BaseFragmentImpl<P extends BasePresenter, DB extends ViewDataBinding> extends Fragment implements BaseView {

    @Inject
    protected P presenter;

    protected DB dataBinding;
    protected MainView activityContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activityContext = (MainView) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(inflater, getContentView(), container, false);
        return dataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewReady();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activityContext = null;
    }

    protected abstract int getContentView();
}
