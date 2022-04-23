package com.appadvc.finalproj.model;

import com.appadvc.finalproj.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryID;

    @Column(nullable = false)
    private String categoryName;

    public Categories (CategoryDTO categoryDTO) {
        this.categoryID = categoryDTO.getCategoryID();
        this.categoryName = categoryDTO.getCategoryName();
    }
}
