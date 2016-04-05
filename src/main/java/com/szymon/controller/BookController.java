package com.szymon.controller;

import com.szymon.domain.Book;
import com.szymon.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    // Method to POST some default books. Can be used for testing.
    @RequestMapping(value = "/addBasicBooks")
    public List<Book> addBasicBooks() {
        Book book = new Book();
        book.setTitle("W pustyni i w puszczy");
        book.setAuthor("Henryk Sienkiewicz");
        book.setPages(400);

        Book book1 = new Book();
        book1.setTitle("Dziady IV");
        book1.setAuthor("Adam Mickiewicz");
        book1.setPages(300);

        Book book2 = new Book();
        book2.setTitle("Krzyzacy");
        book2.setAuthor("Henryk Sienkiewicz");
        book2.setPages(900);


        bookRepository.save(book);
        bookRepository.save(book1);
        bookRepository.save(book2);

        return bookRepository.listAll();
    }

    // PUT because it updates book repository
    @RequestMapping(value = "/clear", method = RequestMethod.PUT)
    public List<Book> clear() {
        return bookRepository.dropAll();
    }


}
