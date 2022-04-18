package com.appadvc.finalproj.model;

import com.appadvc.finalproj.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "categories_categoryID")
    private Categories categories;

    @Column
    private String imageLocation;

    public Products(ProductDTO productDTO) {
        this.productID = productDTO.getProductid();
        this.productName = productDTO.getProductname();
        this.description = productDTO.getDescription();
        this.qty = productDTO.getQuantity();
        this.price = productDTO.getPrice();
    }
}
