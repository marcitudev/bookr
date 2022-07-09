package com.bookr.bookr.DTOs;

import com.bookr.bookr.domains.Book;

public class BookDTO {

    private Long id;
    private String title;

    public BookDTO(BookDTO value) {
        super();
    }

    public BookDTO(Book book) {
        super();
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
