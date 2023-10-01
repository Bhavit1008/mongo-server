package com.backend.server.controller;

import com.backend.server.model.CompanyDetails;
import com.backend.server.model.Order;
import com.backend.server.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CompanyDetailsController {

    @Autowired
    CompanyRepository companyRepository;

    /*
    * Add company details
    *
    * */
    @PostMapping("/addCompany")
    public ResponseEntity<Map<String,String>> addOrder(@RequestBody CompanyDetails cDetails){
        //Order order = new Order("tb1","HandiCraft","Table top");
        CompanyDetails companyDetails = companyRepository.save(cDetails);
        Map<String,String> response = new HashMap<>();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Access-Control-Allow-Origin","https://setu-crm.web.app");
//        headers.set("Access-Control-Allow-Methods","POST, GET, PUT, UPDATE, OPTIONS");
//        headers.set("Access-Control-Allow-Headers","Content-Type, Accept, X-Requested-With");
        if(companyDetails!=null){
            response.put("status","200");
            response.put("message","Added successfully");
        } else{
            response.put("status","404");
            response.put("message","Not added company");
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*
    * get all the companies details.
    *
    * */
    @GetMapping("/getCompany")
    public List<CompanyDetails> mytOrder(){
        List<CompanyDetails> companyDetails = companyRepository.findAll();
        return companyDetails;
    }

    /*
    * update company details
    *
    * */
    @PutMapping("/updateCompany")
    public String updateOrder(@RequestBody CompanyDetails companyDetails){
        List<CompanyDetails> cDetails = companyRepository.findAll();
        if(cDetails != null || cDetails.size()!=0){
            for(CompanyDetails o:cDetails){
                if(o.getId().equals(companyDetails.getId())){
                    companyRepository.save(companyDetails);
                }
            }
        }
        return "updated";
    }

    @PostMapping("/deleteCompany")
    public ResponseEntity<Map<String,String>> deleteOrder(@RequestBody CompanyDetails cDetails){
        List<CompanyDetails > companyDetails = companyRepository.findAll();
        Map<String,String> response = new HashMap<>();
        if(companyDetails != null || companyDetails.size()!=0){
            for(CompanyDetails o:companyDetails){
                if(o.getId().equals(cDetails.getId())){
                    companyRepository.delete(cDetails);
                    if(o!=null){
                        response.put("status","200");
                        response.put("message","Deleted successfully");
                    } else{
                        response.put("status","404");
                        response.put("message","Not deleted order");
                    }
                }
            }
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
