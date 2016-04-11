package com.cognifide.repository;

import com.cognifide.domain.Book;
import com.cognifide.domain.BookNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cognifide.nowak on 04.04.2016.
 */
@Component
public class BookRepositoryInMemory implements BookRepository {

    private List<Book> bookList = Collections.synchronizedList(new ArrayList<Book>());


    public Book findOne(int id) {
        try {
            return bookList.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new BookNotFoundException();
        }
    }

    public void save(Book book) {
        bookList.add(book);
    }

    public Book delete(int id) {
        try {
            Book temp = bookList.remove(id);
            return temp;
        } catch (IndexOutOfBoundsException e ) {
            throw new BookNotFoundException();
        }
    }

    public List<Book> findByAuthor(String author) {
        List<Book> results = new ArrayList<Book>();
        for (Book book : bookList) {
            if(book.getAuthor().equals(author))
                results.add(book);
        }
        if(results.size() == 0)
            throw new BookNotFoundException();
        return results;
    }

    public Book findByTitle(String title) {
        for (Book book : bookList) {
            if(book.getTitle().equals(title))
                return book;
        }
        throw new BookNotFoundException();
    }

    public List<Book> listAll() {
        return bookList;
    }

    public List<Book> dropAll() {
        if(bookList.size() == 0)
            throw new BookNotFoundException();
        List<Book> books = new ArrayList<Book>(bookList.size());
        for (Book book : bookList) {
            books.add(book);
        }
        bookList.clear();
        return books;
    }
}
