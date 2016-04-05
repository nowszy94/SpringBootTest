package com.szymon.repository;

import com.szymon.domain.Book;

import java.util.List;

/**
 * Created by szymon.nowak on 04.04.2016.
 */
public interface BookRepository {

    Book findOne(int id);
    void save(Book book);
    Book delete(int id);
    List<Book> listAll();
}
