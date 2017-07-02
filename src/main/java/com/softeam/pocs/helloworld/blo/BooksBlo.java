package com.softeam.pocs.helloworld.blo;

import com.softeam.pocs.helloworld.dao.BooksDao;
import com.softeam.pocs.helloworld.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by elkouhen on 02/07/17.
 */
@Component
@Transactional
public class BooksBlo {

    @Autowired
    private BooksDao booksDao;

    public Collection<BookDto> findAll() {

        return booksDao.findAll();
    }
}
