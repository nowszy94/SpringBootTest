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

    @PostConstruct
    public void initWithBasicData() {
        Book book = new Book.BookBuilder("W pustyni i w puszczy", "Henryk Sienkiewicz").pages(400).build();
        Book book1 = new Book.BookBuilder("Dziady IV", "Adam Mickiewicz").pages(300).build();
        Book book2 = new Book.BookBuilder("Krzyzacy", "Henryk Sienkiewicz").pages(900).build();

        save(book);
        save(book1);
        save(book2);
    }

}
