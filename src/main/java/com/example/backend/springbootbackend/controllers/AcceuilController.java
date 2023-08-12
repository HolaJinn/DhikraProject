package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Acceuil;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.AcceuilService;
import com.example.backend.springbootbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AcceuilController {
    @Autowired
    AcceuilService acceuilService;

    @GetMapping(value = "/acceuil")
    public List<Acceuil> getAllAcceuil() {
        return acceuilService.getAllAcceuil();
    }

    @PostMapping("/acceuil")
    public Acceuil createAcceuil(@RequestBody Acceuil acceuil) {
        return acceuilService.createAcceuil(acceuil);
    }

    @PutMapping("/acceuil/{id}")
    public Acceuil updateAcceuil(@PathVariable Long id, @RequestBody Acceuil acceuil) {
        acceuil.setId(id);
        Acceuil updateAcceuil = acceuilService.updateAcceuil(acceuil);
        if (updateAcceuil == null) {
            throw new RessourceNotFoundException("Acceuil with ID " + id + " not found.");
        }
        return updateAcceuil;
    }

    @DeleteMapping("/acceuil/{id}")
    public void deleteAcceuil(@PathVariable Long id) {
        acceuilService.deleteAcceuil(id);
    }
    @GetMapping("/acceuil/{id}")
    public Acceuil getAcceuilById(@PathVariable Long id) {
        return acceuilService.getAcceuilById(id);
    }
}
