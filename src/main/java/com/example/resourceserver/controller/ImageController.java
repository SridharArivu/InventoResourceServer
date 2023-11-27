package com.example.resourceserver.controller;


import com.example.resourceserver.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/image")
@RestController
public class ImageController {

    @Autowired
    private ImageStorageService service;

    @PostMapping
    public ResponseEntity<?> uploadImage(
            @RequestParam("image") MultipartFile file,
            @RequestParam("productId") String Id
    ) throws IOException {
        String uploadImage = service.uploadImage(file,Id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);

    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }
}
