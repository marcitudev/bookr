package com.bookr.bookr;

import com.bookr.bookr.domain.Book;
import com.bookr.bookr.domain.Category;
import com.bookr.bookr.repository.BookRepository;
import com.bookr.bookr.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookrApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category = new Category(null, "Informatic", "Informatic books");
		Book book = new Book(null, "Clean Code", "Robert Martin", "Lorem Ipsum", category);

		category.getBooks().addAll(Arrays.asList(book));

		categoryRepository.saveAll(Arrays.asList(category));
		bookRepository.saveAll(Arrays.asList(book));
	}
}
