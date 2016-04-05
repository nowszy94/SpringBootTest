package com.szymon.domain;

/**
 * Created by szymon.nowak on 04.04.2016.
 */
public class Book {

    private String title;
    // FirstName Surname
    private String author;
    private int pages;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
