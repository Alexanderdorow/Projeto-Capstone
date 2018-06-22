package com.dorow.alexander.subreddit.api.dto.search;

public class SubredditSearchDto {

    private SubredditSearchData data;

    public SubredditSearchDto() {
    }

    public SubredditSearchDto(SubredditSearchData data) {
        this.data = data;
    }

    public SubredditSearchData getData() {
        return data;
    }

    public void setData(SubredditSearchData data) {
        this.data = data;
    }


}
