package com.dorow.alexander.subreddit.ui.topic.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.api.dto.subreddit.TopicDto;

import java.util.List;

public class CommentFragment extends Fragment {

    public static CommentFragment getInstance(List<TopicDto> comments) {
        CommentFragment fragment = new CommentFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_comments, container, false);
    }
}
