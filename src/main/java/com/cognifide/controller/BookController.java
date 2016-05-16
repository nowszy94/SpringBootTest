package com.cognifide.controller;

import com.cognifide.domain.Book;
import com.cognifide.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(
            method = RequestMethod.GET)
    public List<Book> listAll() {
        return bookRepository.listAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = {"title"})
    public Book findByTitle(@RequestParam(value = "title") String title) {
        return bookRepository.findByTitle(title);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            params = {"author"})
    public List<Book> findByAuthor(@RequestParam(value = "author") String author) {
        return bookRepository.findByAuthor(author);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public Book get(@PathVariable("id") int id) {
        return bookRepository.findOne(id);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public Book delete(@PathVariable("id") int id) {
        return bookRepository.delete(id);
    }

    // PUT because it updates book repository
    @RequestMapping(
            value = "/clear",
            method = RequestMethod.PUT)
    public List<Book> clear() {
        return bookRepository.dropAll();
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public void exceptionHandler() {
        System.out.println("MethodArgumentTypeMismatchException occurred");
    }
}