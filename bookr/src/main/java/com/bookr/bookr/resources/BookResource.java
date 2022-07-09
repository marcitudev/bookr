package com.bookr.bookr.resources;

import com.bookr.bookr.DTOs.BookDTO;
import com.bookr.bookr.domains.Book;
import com.bookr.bookr.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id,
                                       @RequestBody Book book){
        Book bookUpdated = service.update(id, book);
        return ResponseEntity.ok().body(bookUpdated);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestParam Long category_id, @RequestBody Book book){
        Book bookCreate = service.create(category_id, book);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(bookCreate);
    }
}
