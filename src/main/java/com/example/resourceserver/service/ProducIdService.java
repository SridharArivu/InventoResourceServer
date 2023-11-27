package com.example.resourceserver.service;

import com.example.resourceserver.entity.Product;
import com.example.resourceserver.entity.ProductIdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProducIdService {

    @Autowired
    private addProductService Service;
    public List<Map<String,String>> fetchAllProductId(){

        List<Product> product = Service.findAllProduct();

        List<Map<String,String>> productIdEntity = new ArrayList<>();

        for (Product id: product) {

            HashMap<String,String> value = new HashMap<>();
            value.put("value",id.getProductId());
            value.put("label",id.getTitle());

            Map<String,String> prod = new HashMap<>(value);

            productIdEntity.add(prod);
        }

        System.out.println("ProductIDS :" +productIdEntity);
        return productIdEntity;

    }
}
