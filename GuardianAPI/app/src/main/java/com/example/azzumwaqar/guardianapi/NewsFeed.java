package com.example.azzumwaqar.guardianapi;

import java.util.Date;

public class NewsFeed {
    private String title;
    private String section;
    private Date date;

    public NewsFeed(String title, String section, Date date) {
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

    public Date getDate() {
        return date;
    }
}
