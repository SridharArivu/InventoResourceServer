package com.example.resourceserver.service;


import com.example.resourceserver.config.SecurityConfig;
import com.example.resourceserver.entity.Category;
import com.example.resourceserver.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Map<String,String>> getCategory(){

        List<Category> categoryList = categoryRepository.findAllByClientId(SecurityConfig.clientID);

        List<Map<String,String>> Data = new ArrayList<>();
        for (Category category:categoryList) {
            Map<String,String> BodyData = new HashMap<>();
            BodyData.put("value", category.getValue());
            BodyData.put("label", category.getLabel());
            Data.add(BodyData);
        }

        return Data;
    }

}
