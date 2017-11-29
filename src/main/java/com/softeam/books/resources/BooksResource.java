package com.softeam.books.resources;

import com.softeam.books.blo.BooksBlo;
import com.softeam.books.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by elkouhen on 27/06/17.
 */
@RestController
@RequestMapping(path = "/books")
public class BooksResource {

    @Autowired
    private BooksBlo booksBlo;

    @GetMapping
    public Collection<BookDto> helloworld() {
        Collection<BookDto> all = booksBlo.findAll();
        return all;
    }

}
