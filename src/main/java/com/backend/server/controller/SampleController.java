package com.backend.server.controller;

import com.backend.server.model.Sample;
import com.backend.server.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/architects/samples")
public class SampleController {

    @Autowired
    SampleRepository sampleRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Sample sample) {
        if (sample.getArchitectId() == null || sample.getArchitectId().isBlank()) {
            return ResponseEntity.badRequest().body("architectId is required");
        }
        if (sample.getMaterialName() == null || sample.getMaterialName().isBlank()) {
            return ResponseEntity.badRequest().body("materialName is required");
        }
        sample.setCreatedAt(System.currentTimeMillis());
        return new ResponseEntity<>(sampleRepo.save(sample), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Sample sample) {
        if (!sampleRepo.existsById(id)) return ResponseEntity.notFound().build();
        sample.setId(id);
        return ResponseEntity.ok(sampleRepo.save(sample));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sample>> getAll() {
        return ResponseEntity.ok(sampleRepo.findAll());
    }

    @GetMapping("/architect/{architectId}")
    public ResponseEntity<List<Sample>> byArchitect(@PathVariable String architectId) {
        return ResponseEntity.ok(sampleRepo.findByArchitectIdOrderByCreatedAtDesc(architectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!sampleRepo.existsById(id)) return ResponseEntity.notFound().build();
        sampleRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
