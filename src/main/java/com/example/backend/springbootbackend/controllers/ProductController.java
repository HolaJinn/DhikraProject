package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products")
    public List<Produit> getAllProduits() {
        return productService.getAllProduits();
    }

    @PostMapping("/products")
    public Produit createProduit(@RequestBody Produit produit) {
        return productService.createProduit(produit);
    }

    @PutMapping("/products/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        produit.setId(id);
        Produit updatedProduit = productService.updateProduit(produit);
        if (updatedProduit == null) {
            throw new RessourceNotFoundException("Product with ID " + id + " not found.");
        }
        return updatedProduit;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduit(@PathVariable Long id) {
        productService.deleteProduit(id);
    }
    @GetMapping("/products/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return productService.getProduitById(id);
    }
}

