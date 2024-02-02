package com.backend.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.server.model.GatePass;
import com.backend.server.model.GatePassEntries;
import com.backend.server.repository.GatePassEntriesRepository;
import com.backend.server.repository.GatePassRepository;

@RestController
@CrossOrigin(origins = "*")
public class GatePassController {
	
	 @Autowired
	 GatePassEntriesRepository gatePassEntriesRepository;
	 
	 @Autowired
	 GatePassRepository gatePassRepo;
	 

	 @GetMapping("/allGatePasses")
	    public List<GatePass> getAllGatePasses(){
	        List<GatePassEntries> gatepasses = gatePassEntriesRepository.findAll();
	        List<GatePass> allGatepasses = new ArrayList<>();
	        
	        for(GatePassEntries gp: gatepasses) {
	        	for(GatePass g: gp.getGatepasses()) {
	        		allGatepasses.add(g);
	        	}
	        	
	        }
	        System.out.println("Gatepasses: " +allGatepasses);
	        return allGatepasses;
	    }
	 
	 @PostMapping("/addGatePass")
	    public ResponseEntity<Map<String,String>> addGatePass(@RequestBody GatePassEntries gpEntries){
	      
		 //System.out.println("inside controller");
		 
		 Map<String,String> response = new HashMap<>();
		 for(GatePass g:gpEntries.getGatepasses()) {
			 gatePassRepo.save(g);
		 }
		 
		  GatePassEntries entry = new GatePassEntries(gpEntries.getId(), gpEntries.getGatepasses());
		  gatePassEntriesRepository.save(entry);
		  //System.out.println("Entry:"  +entry);
		  
			   if(entry!=null){
		            response.put("status","200");
		            response.put("message","Added successfully");
		        } else{
		            response.put("status","404");
		            response.put("message","Entry not added");
		        }
		   
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }
}
