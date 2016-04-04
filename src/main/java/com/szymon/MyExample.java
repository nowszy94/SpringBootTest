package com.szymon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by szymon.nowak on 01.04.2016.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/")
public class MyExample {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String home(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyExample.class, args);
    }
}
