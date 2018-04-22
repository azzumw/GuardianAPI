package com.example.azzumwaqar.guardianapi;

import java.util.Date;

public class NewsFeed {
    private String title;
    private String section;
    private String date;
    private String url;

    public NewsFeed(String title, String section, String date) {
        this.title = title;
        this.section = section;
        this.date = date;
    }

    public NewsFeed(String title, String section, String date, String url) {
        this.title = title;
        this.section = section;
        this.date = date;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
