package com.cognifide.repository;

import com.cognifide.domain.Book;
import com.cognifide.domain.BookNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookRepositoryInMemory implements BookRepository {

    private List<Book> bookList = Collections.synchronizedList(new ArrayList<>());

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
        return bookList.remove(id);
    }

    public List<Book> findByAuthor(String author) {
        return bookList
                .stream()
                .filter((book) -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public Book findByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title))
                return book;
        }
        return null;
    }

    public List<Book> listAll() {
        return bookList;
    }

    public List<Book> dropAll() {
        List<Book> books = new ArrayList<>();
        Collections.copy(books, bookList);
        bookList.clear();
        return books;
    }
}