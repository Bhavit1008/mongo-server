package com.backend.server.controller;

import com.backend.server.model.Interaction;
import com.backend.server.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/architects/interactions")
public class InteractionController {

    @Autowired
    InteractionRepository interactionRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Interaction interaction) {
        if (interaction.getArchitectId() == null || interaction.getArchitectId().isBlank()) {
            return ResponseEntity.badRequest().body("architectId is required");
        }
        if (interaction.getType() == null || interaction.getType().isBlank()) {
            return ResponseEntity.badRequest().body("type is required");
        }
        interaction.setCreatedAt(System.currentTimeMillis());
        return new ResponseEntity<>(interactionRepo.save(interaction), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Interaction>> getAll() {
        return ResponseEntity.ok(interactionRepo.findAll());
    }

    @GetMapping("/architect/{architectId}")
    public ResponseEntity<List<Interaction>> byArchitect(@PathVariable String architectId) {
        return ResponseEntity.ok(interactionRepo.findByArchitectIdOrderByCreatedAtDesc(architectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!interactionRepo.existsById(id)) return ResponseEntity.notFound().build();
        interactionRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
