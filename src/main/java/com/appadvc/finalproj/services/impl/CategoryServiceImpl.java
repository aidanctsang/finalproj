package com.appadvc.finalproj.services.impl;

import com.appadvc.finalproj.dto.CategoryDTO;
import com.appadvc.finalproj.model.Categories;
import com.appadvc.finalproj.repository.CategoryRepository;
import com.appadvc.finalproj.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> list() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(CategoryDTO categoryDTO) {
        Categories categories = new Categories(categoryDTO);
        categoryRepository.save(categories);
    }

    @Override
    public CategoryDTO get(Long id) {
        return new CategoryDTO(categoryRepository.findById(id).get());
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        categoryRepository.save(new Categories(categoryDTO));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
