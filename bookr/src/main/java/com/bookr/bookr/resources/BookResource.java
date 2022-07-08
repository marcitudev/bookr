package com.bookr.bookr.resources;

import com.bookr.bookr.DTOs.BookDTO;
import com.bookr.bookr.domains.Book;
import com.bookr.bookr.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/book")
public class BookResource {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = service.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(required = false) Long category_id){
        List<BookDTO> books = Objects.nonNull(category_id) ? service.findAllByCategory(category_id) : service.findAll();
        return ResponseEntity.ok().body(books);
    }
}
