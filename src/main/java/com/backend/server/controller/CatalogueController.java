package com.backend.server.controller;

import com.backend.server.model.CatalogueItem;
import com.backend.server.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    CatalogueRepository catalogueRepo;

    @PostMapping("/add")
    public ResponseEntity<CatalogueItem> add(@RequestBody CatalogueItem item) {
        item.setCreatedAt(System.currentTimeMillis());
        return new ResponseEntity<>(catalogueRepo.save(item), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CatalogueItem>> getAll() {
        return ResponseEntity.ok(catalogueRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogueItem> getById(@PathVariable String id) {
        return catalogueRepo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogueItem> update(@PathVariable String id, @RequestBody CatalogueItem item) {
        if (!catalogueRepo.existsById(id)) return ResponseEntity.notFound().build();
        item.setId(id);
        return ResponseEntity.ok(catalogueRepo.save(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!catalogueRepo.existsById(id)) return ResponseEntity.notFound().build();
        catalogueRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CatalogueItem>> filter(
            @RequestParam(required = false) String material,
            @RequestParam(required = false) String origin) {

        List<CatalogueItem> all = catalogueRepo.findAll();
        return ResponseEntity.ok(all.stream()
            .filter(i -> material == null || material.isBlank() || material.equalsIgnoreCase(i.getMaterial()))
            .filter(i -> origin   == null || origin.isBlank()   || origin.equalsIgnoreCase(i.getOrigin()))
            .toList());
    }
}
