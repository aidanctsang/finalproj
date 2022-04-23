package com.appadvc.finalproj.controller;

import com.appadvc.finalproj.dto.CategoryDTO;
import com.appadvc.finalproj.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("categories", categoryService.list());
        return "category/index";
    }

    @GetMapping("/add")
    private String getCategoryAddForm(Model model) {
        model.addAttribute("category", new CategoryDTO());
        return "category/add-category";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("category") CategoryDTO category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", category);
            return "category/add-category";
        }
        categoryService.add(category);
        return list(model);
    }

    @GetMapping("/{categoryID}")
    private String get(@PathVariable Long categoryID, Model model) {
        model.addAttribute("category", categoryService.get(categoryID));
        return "category/view-category";
    }

    @PutMapping
    private String update(CategoryDTO category, Model model) {
        categoryService.update(category);
        return list(model);
    }

    @DeleteMapping
    private String delete(CategoryDTO category, Model model) {
        categoryService.delete(category.getCategoryID());
        return list(model);
    }
}
