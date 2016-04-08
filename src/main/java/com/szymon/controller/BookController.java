package com.szymon.controller;

import com.szymon.domain.Book;
import com.szymon.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szymon.nowak on 04.04.2016.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book get(@PathVariable("id") int id) {
        return bookRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> listAll() {
        return bookRepository.listAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Book delete(@PathVariable("id") int id) {
        return bookRepository.delete(id);
    }

    // PUT because it updates book repository
    @RequestMapping(value = "/clear", method = RequestMethod.PUT)
    public List<Book> clear() {
        return bookRepository.dropAll();
    }

    @RequestMapping(value = "/titles/{title}", method = RequestMethod.GET)
    public Book findByTitle(@PathVariable("title") String title) {
        return bookRepository.findByTitle(title);
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<String> listAuthors() {
        List<String> authors = new ArrayList<String>();
        for (Book book : bookRepository.listAll()) {
            authors.add(book.getAuthor());
        }
        return authors;
    }

    @RequestMapping(value = "/authors/{author}", method = RequestMethod.GET)
    public List<Book> findByAuthor(@PathVariable("author") String author) {
        return bookRepository.findByAuthor(author);
    }

}
