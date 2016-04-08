package com.szymon.repository;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.szymon.domain.Book;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
        return bookList.get(id);
    }

    public void save(Book book) {
        bookList.add(book);
    }

    public Book delete(int id) {
        Book temp = bookList.remove(id);
        return temp;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> results = new ArrayList<Book>();
        for (Book book : bookList) {
            if(book.getAuthor().equals(author))
                results.add(book);
        }
        return results;
    }

    public Book findByTitle(String title) {
        for (Book book : bookList) {
            if(book.getTitle().equals(title))
                return book;
        }
        return null;
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
