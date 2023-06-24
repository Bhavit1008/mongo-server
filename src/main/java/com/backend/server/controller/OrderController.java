package com.backend.server.controller;

import com.backend.server.model.Order;
import com.backend.server.repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    MongoRepository mongoRepository;

    @GetMapping("test")
    public List<Order> mytOrder(){
        List<Order> orders = mongoRepository.findAll();
        return orders;
    }

    @PostMapping("/addOrder")
    public String addOrder(){
        Order order = new Order("tb1","HandiCraft","Table top");
        mongoRepository.save(order);
        return "added";
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
    public String deleteOrder(@RequestBody Order order){
        List<Order > orders = mongoRepository.findAll();
        if(orders != null || orders.size()!=0){
            for(Order o:orders){
                if(o.getId().equals(order.getId())){
                    mongoRepository.delete(order);
                }
            }
        }
        return "deleted";
    }

}
