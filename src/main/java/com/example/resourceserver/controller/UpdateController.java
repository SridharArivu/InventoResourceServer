package com.example.resourceserver.controller;


import com.example.resourceserver.entity.Product;
import com.example.resourceserver.service.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/updateProduct")
public class UpdateController {

    @Autowired
    private UpdateProductService updateProductService;
    @PostMapping
    public String addingProduct(
            @RequestParam String productId,
            @RequestParam String category,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Integer price,
            @RequestParam Integer quantity,
            @RequestParam String size,
            @RequestParam String ImageURL
    ){
        Product updatedData = new Product();
        updatedData.setProductId(productId);
        updatedData.setCategory(category);
        updatedData.setTitle(title);
        updatedData.setDescription(description);
        updatedData.setPrice(price);
        updatedData.setQuantity(quantity);
        updatedData.setSize(size);
        updatedData.setImageURL(ImageURL);

        updateProductService.updateProduct(updatedData);
        return "The product was successfully updated";
    }
}
