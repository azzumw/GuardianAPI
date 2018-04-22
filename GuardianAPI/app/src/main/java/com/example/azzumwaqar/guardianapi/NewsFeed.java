package com.example.azzumwaqar.guardianapi;


public class NewsFeed {
    private String title;
    private String section;
    private String date;
    private String url;
    private String author = "Not Available";

    public NewsFeed(String title, String section, String date,String url) {
        this.title = title;
        this.section = section;
        this.date = date;
        this.url = url;
    }

    public NewsFeed(String title, String section, String date, String url,String author) {
        this.title = title;
        this.section = section;
        this.date = date;
        this.url = url;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public boolean hasNoAuthor(){
        return author.equals("Not Available");
    }
}
