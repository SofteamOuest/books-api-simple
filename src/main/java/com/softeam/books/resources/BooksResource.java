package com.softeam.books.resources;

import com.softeam.books.dto.BookDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by elkouhen on 27/06/17.
 */
@RestController
@RequestMapping(path = "/books")
public class BooksResource {


    @CrossOrigin("*")
    @GetMapping
    public Collection<BookDto> books() {
        final ArrayList books = new ArrayList();

        books.add(new BookDto(1, "title", "author 1"));
        return books;
    }

}
