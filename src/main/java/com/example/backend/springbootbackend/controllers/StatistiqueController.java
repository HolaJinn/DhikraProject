package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.domain.Statistique;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ProductService;
import com.example.backend.springbootbackend.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class StatistiqueController {
    @Autowired
    StatistiqueService statistiqueService;

    @GetMapping(value = "/statistique")
    public List<Statistique> getAllStatistique() {
        return statistiqueService.getAllStatistique();
    }

    @PostMapping("/statistique")
    public Statistique createStatistique(@RequestBody Statistique statistique) {
        return statistiqueService.createStatistique(statistique);
    }

    @PutMapping("/statistique/{id}")
    public Statistique updateStatistique(@PathVariable Long id, @RequestBody Statistique statistique) {
        statistique.setId(id);
        Statistique updateStatistique = statistiqueService.updateStatistique(statistique);
        if (updateStatistique == null) {
            throw new RessourceNotFoundException("statistique with ID " + id + " not found.");
        }
        return updateStatistique;
    }

    @DeleteMapping("/statistique/{id}")
    public void deleteStatistique(@PathVariable Long id) {
        statistiqueService.deleteStatistique(id);
    }
    @GetMapping("/statistique/{id}")
    public Statistique getStatistiqueById(@PathVariable Long id) {
        return statistiqueService.getStatistiqueById(id);
    }
}
