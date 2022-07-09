package com.bookr.bookr.DTOs;

import com.bookr.bookr.domains.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryDTO {

    private Long id;

    @NotBlank(message = "Name field required")
    @Size(min = 3, max = 100, message = "Name field must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Description field required")
    @Size(min = 3, max = 500, message = "Description field must be between 3 and 500 characters")
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
