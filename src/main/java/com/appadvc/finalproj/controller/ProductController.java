package com.appadvc.finalproj.controller;

import com.appadvc.finalproj.dto.ProductDTO;
import com.appadvc.finalproj.services.FileStorageService;
import com.appadvc.finalproj.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("products", productService.list());
        return "product/index";
    }

    @GetMapping("/add")
    private String getProductAddForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "product/sellerpage";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "product/sellerpage";
        }
        productService.add(product);
        return list(model);
    }

    @GetMapping("/{productID}")
    private String get(@PathVariable Long productID, Model model) {
        model.addAttribute("product", productService.get(productID));
        return "product/view-product";
    }

    @PutMapping
    private String update(ProductDTO product, Model model) {
        productService.update(product);
        return list(model);
    }

    @DeleteMapping
    private String delete(ProductDTO product, Model model) {
        productService.delete(product.getProductID());
        return list(model);
    }

    @GetMapping(value = "/{productID}/image")
    private ResponseEntity<Resource> getImage(@PathVariable Long productID, Model model) throws IOException {
        ProductDTO productDTO = productService.get(productID);
        Resource resource = fileStorageService.load(productDTO.getImageLoc());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .body(resource);

    }

}
