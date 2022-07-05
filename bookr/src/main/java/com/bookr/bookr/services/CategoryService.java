package com.bookr.bookr.services;

import com.bookr.bookr.DTOs.CategoryDTO;
import com.bookr.bookr.domains.Category;
import com.bookr.bookr.repositories.CategoryRepository;
import com.bookr.bookr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(Long id){
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow(() -> new ObjectNotFoundException("Category not found!"));
    }

    public List<CategoryDTO> findAll(){
        return repository.findAll().stream().map(value -> new CategoryDTO(value)).collect(Collectors.toList());

    }
}
