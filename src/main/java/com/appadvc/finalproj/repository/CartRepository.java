package com.appadvc.finalproj.repository;

import com.appadvc.finalproj.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
