package com.example.resourceserver.service;

import com.example.resourceserver.config.SecurityConfig;
import com.example.resourceserver.entity.Product;
import com.example.resourceserver.repository.addProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class addProductService {

    @Autowired
    private addProductRepository addRepo;

    public void addProduct (Product product){
        addRepo.save(product);
    }

    public List<Product> findAllProduct(){
        return addRepo.findAllByClientId(SecurityConfig.clientID);
    }
}
