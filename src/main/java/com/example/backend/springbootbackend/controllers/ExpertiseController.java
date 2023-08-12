package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Expertise;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ExpertiseService;
import com.example.backend.springbootbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ExpertiseController {
    @Autowired
    ExpertiseService expertiseService;

    @GetMapping(value = "/expertise")
    public List<Expertise> getAllExpertise() {
        return expertiseService.getAllExpertise();
    }

    @PostMapping("/expertise")
    public Expertise createExpertise(@RequestBody Expertise expertise) {
        return expertiseService.createExpertise(expertise);
    }

    @PutMapping("/expertise/{id}")
    public Expertise updateExpertise(@PathVariable Long id, @RequestBody Expertise expertise) {
        expertise.setId(id);
        Expertise updateExpertise = expertiseService.updateExpertise(expertise);
        if (updateExpertise == null) {
            throw new RessourceNotFoundException("Expertise with ID " + id + " not found.");
        }
        return updateExpertise;
    }

    @DeleteMapping("/expertise/{id}")
    public void deleteExpertise(@PathVariable Long id) {
        expertiseService.deleteExpertise(id);
    }
    @GetMapping("/expertise/{id}")
    public Expertise getExpertiseById(@PathVariable Long id) {
        return expertiseService.getExpertiseById(id);
    }
}
