package com.dorow.alexander.subreddit.ui.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.WindowId;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.dorow.alexander.subreddit.R;
import com.dorow.alexander.subreddit.database.AppDatabase;
import com.dorow.alexander.subreddit.database.model.Topic;
import com.dorow.alexander.subreddit.di.component.DaggerWidgetComponent;
import com.dorow.alexander.subreddit.ui.main.MainActivity;

import java.util.List;

import javax.inject.Inject;

public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {

    @Inject
    AppDatabase database;

    private final Context context;
    private final Intent intent;

    private List<Topic> topics;

    public WidgetDataProvider(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }

    @Override
    public void onCreate() {
        DaggerWidgetComponent.create().inject(this);
        topics = database.topicDao().findAll();
    }

    @Override
    public void onDataSetChanged() {
        topics = database.topicDao().findAll();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return database.topicDao().count();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        Topic topic = topics.get(position);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_list_item);
        remoteViews.setTextViewText(R.id.author, topic.getAuthor());
        remoteViews.setTextViewText(R.id.redditPrefix, topic.getSubredditPrefix());
        remoteViews.setTextViewText(R.id.redditTitle, topic.getTitle());
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(MainActivity.WIDGET_TOPIC_EXTRA, topic);
        remoteViews.setOnClickFillInIntent(R.id.parent, intent);
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
