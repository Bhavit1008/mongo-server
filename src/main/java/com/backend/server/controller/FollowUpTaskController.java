package com.backend.server.controller;

import com.backend.server.model.FollowUpTask;
import com.backend.server.repository.FollowUpTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/architects/followups")
public class FollowUpTaskController {

    @Autowired
    FollowUpTaskRepository followUpRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody FollowUpTask task) {
        if (task.getArchitectId() == null || task.getArchitectId().isBlank()) {
            return ResponseEntity.badRequest().body("architectId is required");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            return ResponseEntity.badRequest().body("title is required");
        }
        task.setCreatedAt(System.currentTimeMillis());
        if (task.getStatus() == null || task.getStatus().isBlank()) {
            task.setStatus("Pending");
        }
        return new ResponseEntity<>(followUpRepo.save(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody FollowUpTask task) {
        if (!followUpRepo.existsById(id)) return ResponseEntity.notFound().build();
        task.setId(id);
        if ("Completed".equalsIgnoreCase(task.getStatus()) && task.getCompletedAt() == null) {
            task.setCompletedAt(System.currentTimeMillis());
        }
        return ResponseEntity.ok(followUpRepo.save(task));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FollowUpTask>> getAll() {
        return ResponseEntity.ok(followUpRepo.findAll());
    }

    @GetMapping("/architect/{architectId}")
    public ResponseEntity<List<FollowUpTask>> byArchitect(@PathVariable String architectId) {
        return ResponseEntity.ok(followUpRepo.findByArchitectIdOrderByCreatedAtDesc(architectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!followUpRepo.existsById(id)) return ResponseEntity.notFound().build();
        followUpRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
