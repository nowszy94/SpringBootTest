package com.cognifide;

import com.cognifide.domain.Book;
import com.cognifide.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by cognifide.nowak on 01.04.2016.
 */
@SpringBootApplication
public class MySpringBootApplication {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner bookRepositorydataInitializer(BookRepository br) {
        return new CommandLineRunner() {
            public void run (String... args) throws Exception {
                bookRepository.save(Book.builder().title("W pustyni i w puszczy").author("Henryk Sienkiewicz").pages(400).build());
                bookRepository.save(Book.builder().title("Dziady IV").author("Adam Mickiewicz").pages(300).build());
                bookRepository.save(Book.builder().title("Krzyzacy").author("Henryk Sienkiewicz").pages(900).build());
            }
        };
    }


}
