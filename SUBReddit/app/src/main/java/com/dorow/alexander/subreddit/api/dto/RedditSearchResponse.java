package com.dorow.alexander.subreddit.api.dto;

import java.util.List;

public class RedditSearchResponse {

    public RedditSearchData data;

    public RedditSearchResponse() {
    }

    public RedditSearchData getData() {
        return data;
    }

    public void setData(RedditSearchData data) {
        this.data = data;
    }

    public RedditSearchResponse(RedditSearchData data) {
        this.data = data;
    }

    public class RedditSearchData {
        public List<SubredditSearchDto> children;

        public RedditSearchData() {
        }

        public RedditSearchData(List<SubredditSearchDto> children) {
            this.children = children;
        }

        public List<SubredditSearchDto> getChildren() {
            return children;
        }

        public void setChildren(List<SubredditSearchDto> children) {
            this.children = children;
        }
    }
}