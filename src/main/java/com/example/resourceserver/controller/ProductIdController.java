package com.example.resourceserver.controller;

import com.example.resourceserver.entity.ProductIdEntity;
import com.example.resourceserver.service.ProducIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/allProductIds")
public class ProductIdController {

    @Autowired
    private ProducIdService producIdService;

    @GetMapping()
    public List<Map<String,String>> allProductId(){
        return producIdService.fetchAllProductId();
    }
}
