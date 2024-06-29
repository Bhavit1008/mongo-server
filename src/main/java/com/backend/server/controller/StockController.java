package com.backend.server.controller;

import com.backend.server.model.CompanyDetails;
import com.backend.server.model.Stock;
import com.backend.server.model.StockRequestBody;
import com.backend.server.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.PriorityOrdered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    @PostMapping("/getStock")
    public List<Stock> mytOrder(@RequestBody StockRequestBody request) {
        List<Stock> stocks = stockRepository.findAll();
        List<Stock> filteredStocks = new ArrayList<>();

        List<Stock> filteredStock = new ArrayList<>();

        if (!request.getCategory().equals("") && request.getColor().equals("")) {
            for (int i = 0; i < stocks.size(); i++) {
                if (request.getCategory().equals(stocks.get(i).getProductCategory())) {
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        if (request.getCategory().equals("") && !request.getColor().equals("")) {
            for (int i = 0; i < stocks.size(); i++) {
                if (request.getColor().equals(stocks.get(i).getColor())) {
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        if (!request.getCategory().equals("") && !request.getColor().equals("")) {
            for (int i = 0; i < stocks.size(); i++) {
                if (request.getColor().equals(stocks.get(i).getColor()) &&
                        request.getCategory().equals(stocks.get(i).getProductCategory())) {
                    filteredStock.add(stocks.get(i));
                }
            }
        }


        if (filteredStocks != null) {
            return filteredStock;
        } else {
            return null;
        }

    }

    @PostMapping("/deleteStock")
    public String deleteStock(@RequestBody Stock stock){
        List<Stock> stocks = stockRepository.findAll();
        for(int i=0;i<stocks.size();i++){
            if(stocks.get(i).getId().equals(stock.getId())){
                stockRepository.delete(stock);
            }
        }
         return "deleted";
    }
}
