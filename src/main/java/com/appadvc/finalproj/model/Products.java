package com.appadvc.finalproj.model;

import com.appadvc.finalproj.dto.ProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String qty;

    @Column(nullable = false)
    private String description;

    @Column
    private String imageLocation;

    public Products(ProductDTO productDTO) {
        this.productID = productDTO.getProductID();
        this.productName = productDTO.getProductName();
        this.description = productDTO.getDescription();
        this.qty = productDTO.getQuantity();
        this.price = productDTO.getPrice();
    }
}
