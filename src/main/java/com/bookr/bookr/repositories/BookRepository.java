package com.bookr.bookr.repositories;

import com.bookr.bookr.domains.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b FROM book b WHERE b.category.id = :category_id ORDER BY title")
    List<Book> findAllByCategory(@Param(value = "category_id") Long category_id);
}
