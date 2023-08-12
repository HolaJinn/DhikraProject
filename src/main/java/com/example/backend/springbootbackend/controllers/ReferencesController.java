package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.domain.References;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ProductService;
import com.example.backend.springbootbackend.services.ReferencesService;
import com.example.backend.springbootbackend.services.dto.ReferenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ReferencesController {
    @Autowired
    ReferencesService referencesService;

    @GetMapping(value = "/reference")
    public List<References> getAllReferences() {
        return  referencesService.getAllReferences();
    }

    @PostMapping(path = "/reference", consumes = {"multipart/form-data"})
    public ResponseEntity<String> createReferences(@ModelAttribute ReferenceDTO references) throws IOException {
        System.out.println("hello");
        referencesService.createReferences(references);
        return ResponseEntity.status(HttpStatus.CREATED).body("Object created");
    }

    @PutMapping("/reference/{id}")
    public References updateReferences(@PathVariable Long id, @RequestBody References references) {
        references.setId(id);
        References  updateReferences = referencesService.updateReferences(references);
        if ( updateReferences == null) {
            throw new RessourceNotFoundException("References with ID " + id + " not found.");
        }
        return updateReferences;
    }

    @DeleteMapping("/reference/{id}")
    public void deleteReferences(@PathVariable Long id) {
        referencesService.deleteReferences(id);
    }

    @GetMapping("/reference/{id}")
    public ResponseEntity<References> getReferencesById(@PathVariable Long id) {
        References references =  referencesService.getReferencesById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(references);
    }

    @GetMapping("/images/reference/{id}")
    public ResponseEntity<?> getImageReferencesById(@PathVariable Long id) {
        byte[] image = referencesService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}
