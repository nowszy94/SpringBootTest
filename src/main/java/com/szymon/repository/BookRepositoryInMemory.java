package com.szymon.repository;

import com.szymon.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szymon.nowak on 04.04.2016.
 */
@Component
public class BookRepositoryInMemory implements BookRepository {

    private List<Book> bookList = new ArrayList<Book>();


    public Book findOne(int id) {
        if(id < 0 || id >= bookList.size())
            return null;
        return bookList.get(id);
    }

    public void save(Book book) {
        bookList.add(book);
    }

    public Book delete(int id) {
        if(id < 0 || id >= bookList.size())
            return null;
        Book temp = bookList.remove(id);
        return temp;
    }

    public List<Book> listAll() {
        return bookList;
    }
}
