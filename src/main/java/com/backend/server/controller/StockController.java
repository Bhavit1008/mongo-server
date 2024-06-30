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
        List<Stock> filteredStock = new ArrayList<>();

        //All stock
        if(request.getCategory().equals("Get All Stock")){
            return stocks;
        }

        //only category
        if (!request.getCategory().equals("") && request.getColor().equals("")
        && request.getPrice().equals("")) {
            filteredStock = new ArrayList<>();
            for (int i = 0; i < stocks.size(); i++) {
                if (request.getCategory().equals(stocks.get(i).getProductCategory())) {
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        //only color
        if (request.getCategory().equals("") && !request.getColor().equals("")
        && request.getPrice().equals("")) {
            filteredStock = new ArrayList<>();
            for (int i = 0; i < stocks.size(); i++) {
                if (request.getColor().equals(stocks.get(i).getColor())) {
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        //only price
        if (request.getCategory().equals("") && request.getColor().equals("")
        && !request.getPrice().equals("")) {
            filteredStock = new ArrayList<>();

            String[] priceRange = request.getPrice().split("-");
            for(int i=0;i<stocks.size();i++){
                if(Integer.parseInt(priceRange[0])<=Integer.parseInt(stocks.get(i).getProductRate())
                && Integer.parseInt(priceRange[1])>=Integer.parseInt(stocks.get(i).getProductRate())){
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        //category and color
        if (!request.getCategory().equals("") && !request.getColor().equals("")
        && request.getPrice().equals("")) {
            filteredStock = new ArrayList<>();

            for (int i = 0; i < stocks.size(); i++) {
                if (request.getColor().equals(stocks.get(i).getColor()) &&
                        request.getCategory().equals(stocks.get(i).getProductCategory())) {
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        //color and price
        if (request.getCategory().equals("") && !request.getColor().equals("")
                && !request.getPrice().equals("")) {
            filteredStock = new ArrayList<>();
            List<Stock> temp = new ArrayList<>();

            for (int i = 0; i < stocks.size(); i++) {
                if (request.getColor().equals(stocks.get(i).getColor())) {
                    temp.add(stocks.get(i));
                }
            }

            String[] priceRange = request.getPrice().split("-");
            for(int i=0;i<temp.size();i++){
                if(Integer.parseInt(priceRange[0])<=Integer.parseInt(stocks.get(i).getProductRate())
                        && Integer.parseInt(priceRange[1])>=Integer.parseInt(stocks.get(i).getProductRate())){
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        //category and price
        if (!request.getCategory().equals("") && request.getColor().equals("")
                && !request.getPrice().equals("")) {
            filteredStock = new ArrayList<>();
            List<Stock> temp = new ArrayList<>();

            for (int i = 0; i < stocks.size(); i++) {
                if (request.getCategory().equals(stocks.get(i).getProductCategory())) {
                    temp.add(stocks.get(i));
                }
            }

            String[] priceRange = request.getPrice().split("-");
            for(int i=0;i<temp.size();i++){
                if(Integer.parseInt(priceRange[0])<=Integer.parseInt(stocks.get(i).getProductRate())
                        && Integer.parseInt(priceRange[1])>=Integer.parseInt(stocks.get(i).getProductRate())){
                    filteredStock.add(stocks.get(i));
                }
            }
        }

        //category color and price
        if (!request.getCategory().equals("") && !request.getColor().equals("") &&
                !request.getPrice().equals("")) {
            filteredStock = new ArrayList<>();
            List<Stock> temp = new ArrayList<>();
            for (int i = 0; i < stocks.size(); i++) {
                if (request.getColor().equals(stocks.get(i).getColor()) &&
                        request.getCategory().equals(stocks.get(i).getProductCategory())) {
                    temp.add(stocks.get(i));
                }
            }

            String[] priceRange = request.getPrice().split("-");
            for(int i=0;i<temp.size();i++){
                if(Integer.parseInt(priceRange[0])<=Integer.parseInt(stocks.get(i).getProductRate())
                        && Integer.parseInt(priceRange[1])>=Integer.parseInt(stocks.get(i).getProductRate())){
                    filteredStock.add(stocks.get(i));
                }
            }

        }


        if (filteredStock != null) {
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
