package com.appadvc.finalproj.model;

import com.appadvc.finalproj.dto.CartDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartID;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String qty;

    public Cart(CartDTO cartDTO) {
        this.cartID = cartDTO.getCartID();
        this.productName = cartDTO.getProductName();
        this.price = cartDTO.getPrice();
        this.qty = cartDTO.getQuantity();
    }
}
