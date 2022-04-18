package com.appadvc.finalproj.repository;

import com.appadvc.finalproj.model.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products, Long> {
}
