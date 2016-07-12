package com.cognifide.controller;


import com.cognifide.domain.Book;
import com.cognifide.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> listAuthors() {
        return bookRepository
                .listAll()
                .stream()
                .map(Book::getAuthor)
                .collect(Collectors.toList());
    }
}
