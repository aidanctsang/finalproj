package com.appadvc.finalproj.services;

import com.appadvc.finalproj.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> list();

    void add(ProductDTO productDTO);

    ProductDTO get(Long id);

    void update(ProductDTO productDTO);

    void delete(Long id);
}
