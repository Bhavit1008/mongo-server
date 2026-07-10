package com.backend.server.controller;

import com.backend.server.model.ArchitectDocument;
import com.backend.server.repository.ArchitectDocumentRepository;
import com.backend.server.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/architects/documents")
public class ArchitectDocumentController {

    @Autowired
    ArchitectDocumentRepository documentRepo;

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadImage(file);
        return ResponseEntity.ok(url);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ArchitectDocument document) {
        if (document.getFileUrl() == null || document.getFileUrl().isBlank()) {
            return ResponseEntity.badRequest().body("fileUrl is required");
        }
        if (document.getFileName() == null || document.getFileName().isBlank()) {
            return ResponseEntity.badRequest().body("fileName is required");
        }
        document.setUploadedAt(System.currentTimeMillis());
        return new ResponseEntity<>(documentRepo.save(document), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArchitectDocument>> getAll() {
        return ResponseEntity.ok(documentRepo.findAll());
    }

    @GetMapping("/architect/{architectId}")
    public ResponseEntity<List<ArchitectDocument>> byArchitect(@PathVariable String architectId) {
        return ResponseEntity.ok(documentRepo.findByArchitectIdOrderByUploadedAtDesc(architectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!documentRepo.existsById(id)) return ResponseEntity.notFound().build();
        documentRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
