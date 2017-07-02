package com.softeam.pocs.helloworld.dto;

/**
 * Created by elkouhen on 02/07/17.
 */
public class BookDto {

    private Integer id;

    private String title;

    public BookDto(Integer id, String s) {

        this.id = id;

        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
