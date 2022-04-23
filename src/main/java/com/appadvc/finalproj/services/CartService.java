package com.appadvc.finalproj.services;

import com.appadvc.finalproj.dto.CartDTO;

import java.util.List;

public interface CartService {
    List<CartDTO> list();

    void add(CartDTO cartDTO);

    CartDTO get(Long id);

    void update(CartDTO cartDTO);

    void delete(Long id);
}
