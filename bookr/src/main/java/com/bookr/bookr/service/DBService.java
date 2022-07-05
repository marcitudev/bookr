package com.bookr.bookr.service;

import com.bookr.bookr.domain.Book;
import com.bookr.bookr.domain.Category;
import com.bookr.bookr.repository.BookRepository;
import com.bookr.bookr.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public void dbInstance(){
        Category category = new Category(null, "Informatic", "Informatic books");
        Category category2 = new Category(null, "Design", "Design books");

        Book book = new Book(null, "Clean Code", "Robert Martin", "Lorem Ipsum", category);
        Book book2 = new Book(null, "Design Thinking", "Tim Brown", "Lorem Ipsum", category2);

        category.getBooks().addAll(Arrays.asList(book));
        category2.getBooks().addAll(Arrays.asList(book2));

        categoryRepository.saveAll(Arrays.asList(category, category2));
        bookRepository.saveAll(Arrays.asList(book, book2));
    }
}
