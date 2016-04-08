package com.szymon.domain;

/**
 * Created by szymon.nowak on 04.04.2016.
 */
public class Book {

    private final String title;
    private final String author;
    private int pages;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public static class BookBuilder {

        private final String title;
        private final String author;
        private int pages;

        public BookBuilder(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public BookBuilder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    private Book(BookBuilder bookBuilder) {
        this(bookBuilder.title,bookBuilder.author);
        pages = bookBuilder.pages;
    }
}
