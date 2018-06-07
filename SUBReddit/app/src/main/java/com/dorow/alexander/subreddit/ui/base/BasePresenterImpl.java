package com.dorow.alexander.subreddit.ui.base;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter {

    protected V view;

    public BasePresenterImpl(V view) {
        this.view = view;
    }
}
