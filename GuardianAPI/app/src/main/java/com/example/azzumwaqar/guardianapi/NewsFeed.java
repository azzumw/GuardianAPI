package com.example.azzumwaqar.guardianapi;

import java.util.Date;

public class NewsFeed {
    private String title;
    private String section;
    private String date;

    public NewsFeed(String title, String section, String date) {
        this.title = title;
        this.section = section;
        this.date = date;
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
}
