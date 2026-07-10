package com.backend.server.controller;

import com.backend.server.model.ArchitectNote;
import com.backend.server.repository.ArchitectNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/architects/notes")
public class ArchitectNoteController {

    @Autowired
    ArchitectNoteRepository noteRepo;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ArchitectNote note) {
        if (note.getText() == null || note.getText().isBlank()) {
            return ResponseEntity.badRequest().body("text is required");
        }
        note.setCreatedAt(System.currentTimeMillis());
        return new ResponseEntity<>(noteRepo.save(note), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArchitectNote>> getAll() {
        return ResponseEntity.ok(noteRepo.findAll());
    }

    @GetMapping("/architect/{architectId}")
    public ResponseEntity<List<ArchitectNote>> byArchitect(@PathVariable String architectId) {
        return ResponseEntity.ok(noteRepo.findByArchitectIdOrderByCreatedAtDesc(architectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!noteRepo.existsById(id)) return ResponseEntity.notFound().build();
        noteRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
