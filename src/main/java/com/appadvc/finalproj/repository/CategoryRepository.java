package com.appadvc.finalproj.repository;

import com.appadvc.finalproj.model.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Categories, Long> {
}
