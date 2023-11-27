package com.example.resourceserver.controller;

import com.example.resourceserver.config.SecurityConfig;
import com.example.resourceserver.repository.addProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteProduct {

    @Autowired
    private addProductRepository repository;

    @DeleteMapping()
    public String deleteProduct(@RequestParam String productId){
        repository.deleteByClientIdAndProductId(SecurityConfig.clientID,productId);
        return "Product Deleted Successfully";
    }
}
