package com.mnr.ecommercev1.web;

import com.mnr.ecommercev1.entities.Product;
import com.mnr.ecommercev1.repositories.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class CatalogueRestController {

    private ProductRepository productRepository;

    //injection via constructor,
    public CatalogueRestController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    //Get photo via cet url
    @GetMapping(path = "photoProduct/{id}",produces= MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=productRepository.findById(id).get();
            //va se rendre au apth "C:\Users\pekit\Desktop\PROJECT-ALL\1PROJECT-JEE-intellij\frontEnd\ecommerce-v1-Angular\nomPhoto"
        System.out.println(p.getPhotoName()); //return "unknown.png" (if any image is defined)

        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecommerce-v1/products/"+ p.getPhotoName()));




    }
}
