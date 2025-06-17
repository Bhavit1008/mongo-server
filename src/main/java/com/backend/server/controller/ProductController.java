package com.backend.server.controller;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.server.model.Intrasit;
import com.backend.server.repository.IntransitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.server.model.Product;
import com.backend.server.repository.ProductRepository;
import com.backend.server.service.CloudinaryService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
    ProductRepository productRepository;

    @Autowired
    IntransitRepository intransitRepository;
	
	@Autowired
	private CloudinaryService cloudinaryService;


    @PostMapping("/addTransit")
    public ResponseEntity<?> addIntransit(@RequestBody Intrasit intrasit){
        Intrasit intrasitObj = intransitRepository.save(intrasit);
        return new ResponseEntity<>(intrasitObj, HttpStatus.CREATED);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addOrder(@RequestBody Product product){
        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping ("/getAllProducts")
    public List<Product> getBlocks(){
        List<Product> products = productRepository.findAll();
        return products;
    }
    
    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        String imageUrl = cloudinaryService.uploadImage(file);
        return ResponseEntity.ok(imageUrl);
    }
    
    //internal use only
    @DeleteMapping ("/deleteAllProducts")
    public void deleteAllProducts(){
       productRepository.deleteAll();   
    }
}
