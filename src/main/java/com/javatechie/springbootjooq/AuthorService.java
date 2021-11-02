package com.javatechie.springbootjooq;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Author;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private DSLContext dslContext;

    public void insertAuthor(Author author) {
        dslContext
                .insertInto(Tables.AUTHOR, Tables.AUTHOR.AUTHOR_ID,
                        Tables.AUTHOR.EMAIL, Tables.AUTHOR.NAME)
                .values(author.getAuthorId(), author.getEmail(), author.getName())
                .execute();
    }

    public List<Author> getAuthors() {
        return dslContext
                .selectFrom(Tables.AUTHOR)
                .fetchInto(Author.class);
    }
}
