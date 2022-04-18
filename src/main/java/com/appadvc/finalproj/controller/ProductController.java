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

    @GetMapping("/productlist")
    private String list(Model model) {
        model.addAttribute("products", productService.list());
        return "productlist/index";
    }

    @GetMapping("/addform")
    private String getProductAddForm(Model model) {
        model.addAttribute("products", new ProductDTO());
        return "productlist/sellerpage";
    }

    @PostMapping("/add")
    private String add(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "home/index";
        }
        productService.add(product);
        return list(model);
    }

    @GetMapping("/{id}")
    private String get(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.get(id));
        return "productlist/view-product";
    }

    @PutMapping
    private String update(ProductDTO product, Model model) {
        productService.update(product);
        return list(model);
    }

    @DeleteMapping
    private String delete(ProductDTO product, Model model) {
        productService.delete(product.getProductid());
        return list(model);
    }

    @GetMapping(value = "/{id}/image")
    private ResponseEntity<Resource> getImage(@PathVariable Long id, Model model) throws IOException {
        ProductDTO productDTO = productService.get(id);
        Resource resource = fileStorageService.load(productDTO.getImageLoc());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .body(resource);

    }

}
