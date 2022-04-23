package com.appadvc.finalproj.services.impl;

import com.appadvc.finalproj.dto.CartDTO;
import com.appadvc.finalproj.model.Cart;
import com.appadvc.finalproj.repository.CartRepository;
import com.appadvc.finalproj.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<CartDTO> list() {
        return StreamSupport.stream(cartRepository.findAll().spliterator(), false)
                .map(CartDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(CartDTO cartDTO) {
        Cart cart = new Cart(cartDTO);
        cartRepository.save(cart);
    }

    @Override
    public CartDTO get(Long id) {
        return new CartDTO(cartRepository.findById(id).get());
    }

    @Override
    public void update(CartDTO cartDTO) {
        cartRepository.save(new Cart(cartDTO));
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }
}
