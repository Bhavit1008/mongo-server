package com.backend.server.controller;

import com.backend.server.model.Architect;
import com.backend.server.repository.ArchitectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/architects")
public class ArchitectController {

    @Autowired
    ArchitectRepository architectRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Architect architect) {
        String error = validateRequired(architect);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        long now = System.currentTimeMillis();
        architect.setCreatedAt(now);
        architect.setUpdatedAt(now);
        if (architect.getStatus() == null || architect.getStatus().isBlank()) {
            architect.setStatus("Research");
        }
        return new ResponseEntity<>(architectRepo.save(architect), HttpStatus.CREATED);
    }

    /** Mirrors the mandatory fields on the Add Architect form: Company Name, Type, City. */
    private String validateRequired(Architect a) {
        if (isBlank(a.getCompanyName())) return "Company / Firm Name is required";
        if (isBlank(a.getType()))        return "Type is required";
        if (isBlank(a.getCity()))        return "City is required";
        return null;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Architect architect) {
        if (!architectRepo.existsById(id)) return ResponseEntity.notFound().build();
        String error = validateRequired(architect);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        architect.setId(id);
        architect.setUpdatedAt(System.currentTimeMillis());
        return ResponseEntity.ok(architectRepo.save(architect));
    }

    /** Quick status/stage change from the profile's "Status & Stage" panel. */
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable String id, @RequestBody StatusUpdate update) {
        return architectRepo.findById(id).map(a -> {
            a.setStatus(update.status());
            a.setUpdatedAt(System.currentTimeMillis());
            String today = java.time.LocalDate.now().toString();
            if (a.getFirstContactDate() == null || a.getFirstContactDate().isBlank()) {
                a.setFirstContactDate(today);
            }
            a.setLastContactDate(today);
            if ("Onboarded".equalsIgnoreCase(update.status())
                    && (a.getOnboardedDate() == null || a.getOnboardedDate().isBlank())) {
                a.setOnboardedDate(today);
            }
            return ResponseEntity.ok(architectRepo.save(a));
        }).orElse(ResponseEntity.notFound().build());
    }

    public record StatusUpdate(String status) {}

    @GetMapping("/all")
    public ResponseEntity<List<Architect>> getAll() {
        return ResponseEntity.ok(architectRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Architect> getById(@PathVariable String id) {
        return architectRepo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!architectRepo.existsById(id)) return ResponseEntity.notFound().build();
        architectRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Architect>> filter(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String priority,
            @RequestParam(required = false) String search) {

        List<Architect> all = architectRepo.findAll();
        return ResponseEntity.ok(all.stream()
            .filter(a -> city == null || city.isBlank() || city.equalsIgnoreCase(a.getCity()))
            .filter(a -> type == null || type.isBlank() || type.equalsIgnoreCase(a.getType()))
            .filter(a -> status == null || status.isBlank() || status.equalsIgnoreCase(a.getStatus()))
            .filter(a -> priority == null || priority.isBlank() || priority.equalsIgnoreCase(a.getPriority()))
            .filter(a -> search == null || search.isBlank()
                || (a.getCompanyName() != null && a.getCompanyName().toLowerCase().contains(search.toLowerCase()))
                || (a.getContactPerson() != null && a.getContactPerson().toLowerCase().contains(search.toLowerCase())))
            .toList());
    }
}
