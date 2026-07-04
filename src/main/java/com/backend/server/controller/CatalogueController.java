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
    public ResponseEntity<?> add(@RequestBody CatalogueItem item) {
        String error = validateRequired(item);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        item.setCreatedAt(System.currentTimeMillis());
        return new ResponseEntity<>(catalogueRepo.save(item), HttpStatus.CREATED);
    }

    /**
     * Mirrors the mandatory (*) fields on the Add Marble form:
     * Marble Name, Product Code, Material Type, Stone Family, Country.
     */
    private String validateRequired(CatalogueItem item) {
        if (isBlank(item.getMarbleName()))   return "Marble Name is required";
        if (isBlank(item.getItemCode()))     return "Product Code is required";
        if (isBlank(item.getMaterialType())) return "Material Type is required";
        if (isBlank(item.getStoneFamily()))  return "Stone Family is required";
        if (isBlank(item.getCountry()))      return "Country is required";
        return null;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
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
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CatalogueItem item) {
        if (!catalogueRepo.existsById(id)) return ResponseEntity.notFound().build();
        String error = validateRequired(item);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
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
            .filter(i -> material == null || material.isBlank() || material.equalsIgnoreCase(i.getMaterialType()))
            .filter(i -> origin   == null || origin.isBlank()   || origin.equalsIgnoreCase(i.getCountry()))
            .toList());
    }
}
