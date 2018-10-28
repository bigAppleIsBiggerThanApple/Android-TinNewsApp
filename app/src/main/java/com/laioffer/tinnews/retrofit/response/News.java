package com.laioffer.tinnews.retrofit.response;

import android.support.annotation.NonNull;

public class News {
    public String author;
    @NonNull
    public String title;
    public String description;
    public String url;
    public String image;
    public String time;

    public News() {

    }

    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }
}
