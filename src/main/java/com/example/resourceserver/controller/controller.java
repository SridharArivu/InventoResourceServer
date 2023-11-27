package com.example.resourceserver.controller;

import com.example.resourceserver.config.SecurityConfig;
import com.example.resourceserver.entity.Product;
import com.example.resourceserver.repository.addProductRepository;
import com.example.resourceserver.service.addProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class controller {

    @Autowired
    private addProductService Service;

    @Autowired
    private addProductRepository repository;

    @PostMapping(value = "/addProduct")
    public String addingProduct(
            @RequestParam String productId,
            @RequestParam String category,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Integer price,
            @RequestParam Integer quantity,
            @RequestParam String size,
            @RequestParam String imageURL
    ){
        Product newProduct = new Product();
        newProduct.setClientId(SecurityConfig.clientID);
        newProduct.setProductId(productId.replaceAll("\\s+", ""));
        newProduct.setCategory(category);
        newProduct.setTitle(title);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setQuantity(quantity);
        newProduct.setSize(size);
        newProduct.setImageURL(imageURL);

        Service.addProduct(newProduct);
        return "Product added successfully";
    }


    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam String productId ){

        return repository.findByClientIdAndProductId(SecurityConfig.clientID ,productId);
    }
}

