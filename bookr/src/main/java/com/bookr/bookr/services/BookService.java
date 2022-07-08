package com.bookr.bookr.services;

import com.bookr.bookr.DTOs.BookDTO;
import com.bookr.bookr.domains.Book;
import com.bookr.bookr.repositories.BookRepository;
import com.bookr.bookr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryService categoryService;

    public Book findById(Long id){
        Optional<Book> book = repository.findById(id);
        return book.orElseThrow(() -> new ObjectNotFoundException("Book not found!"));
    }

    public List<BookDTO> findAll(){
        return repository.findAll().stream().map(value -> new BookDTO(value)).collect(Collectors.toList());
    }

    public List<BookDTO> findAllByCategory(Long category_id) {
        categoryService.findById(category_id);
        return repository.findAllByCategory(category_id).stream().map(value -> new BookDTO(value)).collect(Collectors.toList());
    }
}
