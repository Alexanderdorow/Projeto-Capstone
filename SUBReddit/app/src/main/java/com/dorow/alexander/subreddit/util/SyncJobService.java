package com.dorow.alexander.subreddit.util;

import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class SyncJobService extends JobService {

    @Override
    public boolean onStartJob(JobParameters job) {
        new SyncTask().execute();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return false;
    }
}
