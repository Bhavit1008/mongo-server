package com.backend.server.controller;

import com.backend.server.model.Block;
import com.backend.server.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class BlockController {

    @Autowired
    BlockRepository blockRepository;

    @PostMapping("/addBlock")
    public ResponseEntity<Map<String,String>> addOrder(@RequestBody Block inpBlock){
        //Order order = new Order("tb1","HandiCraft","Table top");
        Block block = blockRepository.save(inpBlock);
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

    @GetMapping ("/getBlocks")
    public List<Block> getBlocks(){
        List<Block> blocks = blockRepository.findAll();
        return blocks;
    }
}
