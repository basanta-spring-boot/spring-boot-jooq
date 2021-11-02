package com.javatechie.springbootjooq;

import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/authors")
public class SpringBootJooqApplication {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public String addAuthor(@RequestBody Author author) {
        authorService.insertAuthor(author);
        return "author added...";
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJooqApplication.class, args);
    }

}
