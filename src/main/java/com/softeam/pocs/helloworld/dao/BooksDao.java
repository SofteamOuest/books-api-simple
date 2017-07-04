package com.softeam.pocs.helloworld.dao;

import com.softeam.pocs.helloworld.domain.Tables;
import com.softeam.pocs.helloworld.dto.BookDto;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by elkouhen on 02/07/17.
 */
@Component
public class BooksDao {

    @Autowired
    private DSLContext jooq;

    public Collection<BookDto> findAll() {
        return jooq.select(Tables.T_BOOK.BOK_ID, Tables.T_BOOK.BOK_TITLE).from(Tables.T_BOOK)
                .fetch().map(idAndTitle -> new BookDto(idAndTitle.value1(), idAndTitle.value2()));
    }
}
