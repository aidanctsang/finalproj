package com.appadvc.finalproj.dto;

import com.appadvc.finalproj.model.Categories;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private Long categoryID;

    @NotBlank(message = "Category Name is required")
    private String categoryName;

    public CategoryDTO(Categories categories) {
        this.categoryID = categories.getCategoryID();
        this.categoryName = categories.getCategoryName();
    }
}
