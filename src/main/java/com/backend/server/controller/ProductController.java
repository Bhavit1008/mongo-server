package com.backend.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.server.model.Block;
import com.backend.server.model.Product;
import com.backend.server.repository.BlockRepository;
import com.backend.server.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
    ProductRepository productRepository;

    @PostMapping("/addProduct")
    public ResponseEntity<Map<String,String>> addOrder(@RequestBody Product product){
        //Order order = new Order("tb1","HandiCraft","Table top");
        Product block = productRepository.save(product);
        Map<String,String> response = new HashMap<>();
        if(block !=null){
            response.put("status","200");
            response.put("message","Stock added successfully");
        } else{
            response.put("status","404");
            response.put("message","Error in storing stock");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping ("/getAllProducts")
    public List<Product> getBlocks(){
        List<Product> products = productRepository.findAll();
        return products;
    }
    
    
    //internal use only
    @DeleteMapping ("/deleteAllProducts")
    public void deleteAllProducts(){
       productRepository.deleteAll();   
    }
}
