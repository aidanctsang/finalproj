package com.appadvc.finalproj.services;

import com.appadvc.finalproj.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> list();

    void add(CategoryDTO categoryDTO);

    CategoryDTO get(Long id);

    void update(CategoryDTO categoryDTO);

    void delete(Long id);
}
