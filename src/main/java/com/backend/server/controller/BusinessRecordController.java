package com.backend.server.controller;

import com.backend.server.model.BusinessRecord;
import com.backend.server.repository.BusinessRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/architects/business")
public class BusinessRecordController {

    @Autowired
    BusinessRecordRepository businessRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody BusinessRecord record) {
        if (record.getArchitectId() == null || record.getArchitectId().isBlank()) {
            return ResponseEntity.badRequest().body("architectId is required");
        }
        if (record.getProjectName() == null || record.getProjectName().isBlank()) {
            return ResponseEntity.badRequest().body("projectName is required");
        }
        if (record.getEnquiryNumber() == null || record.getEnquiryNumber().isBlank()) {
            record.setEnquiryNumber("ENQ-" + String.valueOf(System.currentTimeMillis()).substring(7));
        }
        record.setCreatedAt(System.currentTimeMillis());
        return new ResponseEntity<>(businessRepo.save(record), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody BusinessRecord record) {
        if (!businessRepo.existsById(id)) return ResponseEntity.notFound().build();
        record.setId(id);
        return ResponseEntity.ok(businessRepo.save(record));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusinessRecord>> getAll() {
        return ResponseEntity.ok(businessRepo.findAll());
    }

    @GetMapping("/architect/{architectId}")
    public ResponseEntity<List<BusinessRecord>> byArchitect(@PathVariable String architectId) {
        return ResponseEntity.ok(businessRepo.findByArchitectIdOrderByCreatedAtDesc(architectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!businessRepo.existsById(id)) return ResponseEntity.notFound().build();
        businessRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
