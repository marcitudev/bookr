package com.bookr.bookr.resources;

import com.bookr.bookr.DTOs.CategoryDTO;
import com.bookr.bookr.domains.Category;
import com.bookr.bookr.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category){
        category = service.create(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id,
                                              @RequestBody CategoryDTO category){
        Category categoryUpdated = service.update(id, category);
        return ResponseEntity.ok().body(new CategoryDTO(categoryUpdated));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
