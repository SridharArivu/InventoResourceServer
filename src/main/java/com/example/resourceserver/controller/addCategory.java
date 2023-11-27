package com.example.resourceserver.controller;


import com.example.resourceserver.config.SecurityConfig;
import com.example.resourceserver.entity.Category;
import com.example.resourceserver.repository.CategoryRepository;
import com.example.resourceserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class addCategory {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping ("/SaveCategory")
    public Category Category(
            @RequestParam String value,
            @RequestParam String label
    ){
        Category category = new Category();
        category.setClientId(SecurityConfig.clientID);
        category.setValue(value.replaceAll("\\s+", ""));
        category.setLabel(label.replaceAll("\\s+", ""));

        return categoryService.saveCategory(category);

    }

    @GetMapping("/getCategory")
    public List<Map<String,String>> getCategory(){

        return categoryService.getCategory();
    }

    @DeleteMapping("/deleteCategory")
    public String deleteCategory(@RequestParam String categoryName){

        categoryRepository.deleteByValue(categoryName);

        return "Category deleted successfully";

    }
}
