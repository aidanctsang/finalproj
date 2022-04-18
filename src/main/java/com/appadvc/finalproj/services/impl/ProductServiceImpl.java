package com.appadvc.finalproj.services.impl;

import com.appadvc.finalproj.dto.ProductDTO;
import com.appadvc.finalproj.model.Products;
import com.appadvc.finalproj.repository.ProductRepository;
import com.appadvc.finalproj.services.FileStorageService;
import com.appadvc.finalproj.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> list() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(ProductDTO productDTO) {
        Products product = new Products(productDTO);
        if (productDTO.getImage() != null) {
            fileStorageService.save(productDTO.getImage());
            product.setImageLocation(productDTO.getImage().getOriginalFilename());
        }
        productRepository.save(product);
    }

    @Override
    public ProductDTO get(Long id) {
        return new ProductDTO(productRepository.findById(id).get());
    }

    @Override
    public void update(ProductDTO productDTO) {
        productRepository.save(new Products(productDTO));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
