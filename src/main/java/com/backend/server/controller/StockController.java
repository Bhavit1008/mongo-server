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
    public List<Stock> mytOrder(@RequestBody StockRequestBody request){
        List<Stock> stocks = stockRepository.findAll();
        List<Stock> filteredStocks = new ArrayList<>();


        //Admin access
        if(request.getRole().equals("admin")){
            //case-1 : get all stocks when no manager is selected
            if(request.getCategory().equals("Get All Stock") &&
                    request.getManager().equals("")){
                return stocks;
            }

            //case-2 get all stocks when manager is selected
            if(request.getCategory().equals("Get All Stock") &&
                    !request.getManager().equals("")){
                List<Stock> stocks1 = new ArrayList<>();
                for(int i=0;i<stocks.size();i++){
                    if(stocks.get(i).getAssociatedManager().equals(request.getManager())){
                        stocks1.add(stocks.get(i));
                    }
                }
                return stocks1;
            }

            //case-3 if we have dates
            if(request.getStartDate()!=null && request.getStartDate()!="" && request.getCategory().equals("Get All Stock") &&
                    !request.getManager().equals("")){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                LocalDate startDate = LocalDate.parse(request.getStartDate(), formatter);
                LocalDate endDate = LocalDate.parse(request.getEndDate(), formatter);
                List<Stock> dateFiltered = new ArrayList<>();

                for(int i=0;i<filteredStocks.size();i++){
                    LocalDate productDate = LocalDate.parse(filteredStocks.get(i).getDateOfStocking(), formatter);
                    if(!(productDate.isBefore(startDate)) && (productDate.isBefore(endDate)) || productDate.isEqual(endDate)){
                        dateFiltered.add(stocks.get(i));
                    }
                }
                filteredStocks = dateFiltered;
            }

            //case-4
            if(request.getStartDate()!=null && request.getStartDate()!="" && !request.getCategory().equals("") &&
                    !request.getManager().equals("")){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                LocalDate startDate = LocalDate.parse(request.getStartDate(), formatter);
                LocalDate endDate = LocalDate.parse(request.getEndDate(), formatter);
                List<Stock> dateFiltered = new ArrayList<>();

                List<Stock> stocks1 = new ArrayList<>();
                for(int i=0;i<stocks.size();i++){
                    if(stocks.get(i).getAssociatedManager().equals(request.getManager()) && stocks.get(i).getProductCategory().equals(request.getCategory())){
                        stocks1.add(stocks.get(i));
                    }
                }

                for(int i=0;i<stocks1.size();i++){
                    LocalDate productDate = LocalDate.parse(stocks1.get(i).getDateOfStocking(), formatter);
                    if(!(productDate.isBefore(startDate)) && (productDate.isBefore(endDate)) || productDate.isEqual(endDate)){
                        dateFiltered.add(stocks.get(i));
                    }
                }
                filteredStocks = dateFiltered;
            }

            //case-5 when only category and manager is selected
            if(!request.getCategory().equals("") &&
                    !request.getManager().equals("")){
                List<Stock> stocks1 = new ArrayList<>();
                for(int i=0;i<stocks.size();i++){
                    if(stocks.get(i).getAssociatedManager().equals(request.getManager()) && stocks.get(i).getProductCategory().equals(request.getCategory())){
                        stocks1.add(stocks.get(i));
                    }
                }
                return stocks1;
            }

            //case-6 when oly category and dates are selected
            if(!request.getCategory().equals("") &&
                    !request.getStartDate().equals("")){
                List<Stock> stocks1 = new ArrayList<>();
                for(int i=0;i<stocks.size();i++){
                    if(stocks.get(i).getAssociatedManager().equals(request.getManager()) && stocks.get(i).getProductCategory().equals(request.getCategory())){
                        stocks1.add(stocks.get(i));
                    }
                }
                return stocks1;
            }

            //case-6 when oly category and dates are selected
            if(!request.getCategory().equals("") &&
                    !request.getStartDate().equals("")){
                List<Stock> stocks1 = new ArrayList<>();
                for(int i=0;i<stocks.size();i++){
                    if(stocks.get(i).getAssociatedManager().equals(request.getManager()) && stocks.get(i).getProductCategory().equals(request.getCategory())){
                        stocks1.add(stocks.get(i));
                    }
                }
                return stocks1;
            }

            //case-7 when oly category and dates are selected
            if(!request.getCategory().equals("")){
                List<Stock> stocks1 = new ArrayList<>();
                for(int i=0;i<stocks.size();i++){
                    if(stocks.get(i).getProductCategory().equals(request.getCategory())){
                        stocks1.add(stocks.get(i));
                    }
                }
                return stocks1;
            }
        }












//
//        if(request.getCategory()!=null && !request.getCategory().equals("")){
//            if(request.getCategory().equals("Get All Stock")){
//                for(int i=0;i<stocks.size();i++){
//                    //if(request)
//                }
//                filteredStocks = stocks;
//            }
//            else{
//                for(int i=0;i<stocks.size();i++){
//                    if(stocks.get(i).getProductCategory().equals(request.getCategory())){
//                        filteredStocks.add(stocks.get(i));
//                    }
//                }
//            }
//        }
//        if(request.getStartDate()!=null && request.getStartDate()!=""){
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//            LocalDate startDate = LocalDate.parse(request.getStartDate(), formatter);
//            LocalDate endDate = LocalDate.parse(request.getEndDate(), formatter);
//            List<Stock> dateFiltered = new ArrayList<>();
//            for(int i=0;i<filteredStocks.size();i++){
//                LocalDate productDate = LocalDate.parse(filteredStocks.get(i).getDateOfStocking(), formatter);
//                if(!(productDate.isBefore(startDate)) && (productDate.isBefore(endDate)) || productDate.isEqual(endDate)){
//                    dateFiltered.add(stocks.get(i));
//                }
//            }
//            filteredStocks = dateFiltered;
//        }

        return filteredStocks;
    }
}
