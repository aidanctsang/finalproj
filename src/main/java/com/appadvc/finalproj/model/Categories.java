package com.appadvc.finalproj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryID;

    @Column(nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "categories")
    private List<Products> products;

}
