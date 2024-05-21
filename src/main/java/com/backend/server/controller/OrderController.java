package com.backend.server.controller;

import com.backend.server.model.Order;
import com.backend.server.repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    MongoRepository mongoRepository;

    @GetMapping("/test/{designation}/{category}/{manager}")
    public List<Order> mytOrder(@PathVariable String designation,@PathVariable String category, @PathVariable String manager){
        List<Order> orders = mongoRepository.findAll();
        List<Order> ordersByCategory = new ArrayList<>();
        List<Order> ordersByManager = new ArrayList<>();

        if(designation.equals("admin")){
            return orders;
        }

        if(null!=orders && orders.size()>0){
            for(int i=0;i<orders.size();i++){
                if(orders.get(i).getProductCategory().equals(category)){
                    ordersByCategory.add(orders.get(i));
                }
            }

            if(ordersByCategory.size()>0){
                for(int i=0;i<ordersByCategory.size();i++){
                    if(ordersByCategory.get(i).getPrimaryManager().equals(manager)){
                        ordersByManager.add(ordersByCategory.get(i));
                    }
                }
            }
        }
        return ordersByManager;
    }

    @GetMapping("/allOrders")
    public List<Order> getAllOrders(){
        List<Order> orders = mongoRepository.findAll();
        return orders;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Map<String,String>> addOrder(@RequestBody Order order){
        //Order order = new Order("tb1","HandiCraft","Table top");
        Order o = mongoRepository.save(order);
        Map<String,String> response = new HashMap<>();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Access-Control-Allow-Origin","https://setu-crm.web.app");
//        headers.set("Access-Control-Allow-Methods","POST, GET, PUT, UPDATE, OPTIONS");
//        headers.set("Access-Control-Allow-Headers","Content-Type, Accept, X-Requested-With");
        if(o!=null){
            response.put("status","200");
            response.put("message","Added successfully");
        } else{
            response.put("status","404");
            response.put("message","Not added order");
        }
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder")
    public String updateOrder(@RequestBody Order order){
        List<Order > orders = mongoRepository.findAll();
        if(orders != null || orders.size()!=0){
            for(Order o:orders){
                if(o.getId().equals(order.getId())){
                    mongoRepository.save(order);
                }
            }
        }
        return "updated";
    }

    @PostMapping("/deleteOrder")
    public ResponseEntity<Map<String,String>> deleteOrder(@RequestBody Order order){
        List<Order > orders = mongoRepository.findAll();
        Map<String,String> response = new HashMap<>();
        if(orders != null || orders.size()!=0){
            for(Order o:orders){
                if(o.getId().equals(order.getId())){
                    mongoRepository.delete(order);
                    if(o!=null){
                        response.put("status","200");
                        response.put("message","Added successfully");
                    } else{
                        response.put("status","404");
                        response.put("message","Not added order");
                    }
                }
            }
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
//git remote add origin https://github.com/Bhavit1008/CircuitBreaker.git
// git pull https://github.com/Bhavit1008/CircuitBreaker.git master