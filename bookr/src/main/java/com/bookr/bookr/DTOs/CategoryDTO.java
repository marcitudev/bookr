package com.bookr.bookr.DTOs;

import com.bookr.bookr.domains.Category;

public class CategoryDTO {

    private Long id;
    private String name;
    private String description;

    public CategoryDTO() {
        super();
    }

    public CategoryDTO(Category category) {
        super();
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
