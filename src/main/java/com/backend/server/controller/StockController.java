package com.backend.server.controller;

import com.backend.server.model.CompanyDetails;
import com.backend.server.model.Stock;
import com.backend.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    /*
     * Add company details
     *
     * */
    @PostMapping("/addStock")
    public ResponseEntity<Map<String,String>> addOrder(@RequestBody Stock stock){
        //Order order = new Order("tb1","HandiCraft","Table top");
        Stock storedStock = stockRepository.save(stock);
        Map<String,String> response = new HashMap<>();
        if(storedStock!=null){
            response.put("status","200");
            response.put("message","Stock added successfully");
        } else{
            response.put("status","404");
            response.put("message","Error in storing stock");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*
     * get all the companies details.
     *
     * */
    @GetMapping("/getStock")
    public List<Stock> mytOrder(){
        List<Stock> stocks = stockRepository.findAll();
        return stocks;
    }
}
