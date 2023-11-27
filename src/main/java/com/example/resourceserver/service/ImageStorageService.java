package com.example.resourceserver.service;

import com.example.resourceserver.entity.ImageData;
import com.example.resourceserver.repository.ImageStorageRepository;
import com.example.resourceserver.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageStorageService {

    @Autowired
    private ImageStorageRepository imageRepository;

    public String uploadImage(MultipartFile file, String productId) throws IOException {
        ImageData imageData = imageRepository.save(ImageData.builder()
                        .productId(productId)
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());

        return "file uploaded successfully : " + file.getOriginalFilename();
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = imageRepository.findByName(fileName);
        return ImageUtils.decompressImage(dbImageData.get().getImageData());
    }
}
