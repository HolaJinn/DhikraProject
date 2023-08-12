package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Produit;

import java.util.List;

public interface ProductService {
     List<Produit> getAllProduits();
     Produit createProduit(Produit produit);
     Produit updateProduit(Produit produit);
     void deleteProduit(Long id);
     Produit getProduitById(Long id);
}
