package com.mnr.ecommercev1.controllers;

import com.mnr.ecommercev1.entities.Product;
import com.mnr.ecommercev1.repositories.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*") //alow query from all servers
@RestController
public class CatalogueRestController {

    private ProductRepository productRepository;

    //injection via constructor,
    public CatalogueRestController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    //GET PHOTO
    @GetMapping(path = "photoProduct/{id}",produces= MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=productRepository.findById(id).get();
            //va se rendre au apth "C:\Users\pekit\Desktop\PROJECT-ALL\1PROJECT-JEE-intellij\frontEnd\ecommerce-v1-Angular\nomPhoto"
        System.out.println(p.getPhotoName()); //return "unknown.png" (if any image is defined)

        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecommerce-v1/products/"+ p.getPhotoName()));
    }


    //IMPORTANT:POST PHOTO
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        Product p=productRepository.findById(id).get();
        p.setPhotoName(file.getOriginalFilename());
            //package java.nio => entree et sortie non bloquante (io:entree et sortie bloquante)
        Files.write(Paths.get(System.getProperty("user.home")+"/ecommerce-v1/products/"+p.getPhotoName()),file.getBytes());
        productRepository.save(p);
    }


}
