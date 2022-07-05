package com.bookr.bookr.service;

import com.bookr.bookr.domain.Category;
import com.bookr.bookr.repository.CategoryRepository;
import com.bookr.bookr.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(Long id){
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow(() -> new ObjectNotFoundException("Category not found!"));
    }
}