package com.example.resourceserver.service;

import com.example.resourceserver.config.SecurityConfig;
import com.example.resourceserver.entity.Product;
import com.example.resourceserver.repository.addProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UpdateProductService {

    @Autowired
    private addProductRepository addProductRepository;
    public void updateProduct(Product updatedData) {
        Product product = addProductRepository.findByClientIdAndProductId(SecurityConfig.clientID,updatedData.getProductId());
        product.setClientId(SecurityConfig.clientID);
        product.setCategory(updatedData.getCategory());
        product.setTitle(updatedData.getTitle());
        product.setDescription(updatedData.getDescription());
        product.setPrice(updatedData.getPrice());
        product.setQuantity(updatedData.getQuantity());
        product.setSize(updatedData.getSize());

        addProductRepository.save(product);

    }
}
