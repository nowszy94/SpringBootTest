package com.szymon.repository;

import com.szymon.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by szymon.nowak on 04.04.2016.
 */
@Component
public class BookRepositoryInMemory implements BookRepository {

    private List<Book> bookList = Collections.synchronizedList(new ArrayList<Book>());


    public Book findOne(int id) {
        if (id < 0 || id >= bookList.size())
            return null;
        return bookList.get(id);
    }

    public void save(Book book) {
        bookList.add(book);
    }

    public Book delete(int id) {
        if (id < 0 || id >= bookList.size())
            return null;
        Book temp = bookList.remove(id);
        return temp;
    }

    public List<Book> listAll() {
        return bookList;
    }

    public List<Book> dropAll() {
        List<Book> books = new ArrayList<Book>(bookList.size());
        for (Book book : bookList) {
            books.add(book);
        }
        bookList.clear();
        return books;
    }
}
