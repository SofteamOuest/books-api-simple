package com.softeam.books.dto;

/**
 * Created by elkouhen on 02/07/17.
 */
public class BookDto {

    private Integer id;

    private String title;

    private String authors;

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public BookDto(Integer id, String title, String authors) {

        this.id = id;

        this.title = title;

        this.authors = authors;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
