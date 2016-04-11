package com.cognifide.repository;

import com.cognifide.domain.Book;

import java.util.List;

/**
 * Created by cognifide.nowak on 04.04.2016.
 */
public interface BookRepository {

    Book findOne(int id);
    void save(Book book);
    Book delete(int id);
    Book findByTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> listAll();
    List<Book> dropAll();
}
