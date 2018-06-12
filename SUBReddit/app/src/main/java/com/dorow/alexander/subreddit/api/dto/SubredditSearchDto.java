package com.dorow.alexander.subreddit.api.dto;

import com.google.gson.annotations.SerializedName;

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

    public class SubredditSearchData {
        @SerializedName("display_name_prefixed")
        private String subredditPrefix;
        @SerializedName("display_name")
        private String title;
        @SerializedName("description")
        private String description;

        public SubredditSearchData() {
        }

        public SubredditSearchData(String subredditPrefix, String title, String description) {
            this.subredditPrefix = subredditPrefix;
            this.title = title;
            this.description = description;
        }

        public String getSubredditPrefix() {
            return subredditPrefix;
        }

        public void setSubredditPrefix(String subredditPrefix) {
            this.subredditPrefix = subredditPrefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}
