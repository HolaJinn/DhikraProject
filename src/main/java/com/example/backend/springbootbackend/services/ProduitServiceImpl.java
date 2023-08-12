package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProductService{
    @Autowired
    private ProduitRepository produitRepository;


    public List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }
    public Produit createProduit( Produit produit) {
        produit.setCreatedBy("admin");
        produit.setCreatedDate(LocalDateTime.now());
        produit.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
    //    produit.setUpdatedDate(LocalDateTime.now());
        produit.setOperation("SAVE PRODUCT");
        produit.setUtilisateur("admin");
       return produitRepository.save(produit);
    }

    public Produit updateProduit(Produit produit) {
        Produit existingProduit = produitRepository.findById(produit.getId()).orElse(null);

        if (existingProduit != null) {
            existingProduit.setLibAr(produit.getLibAr());
            existingProduit.setLibFr(produit.getLibFr());
            existingProduit.setLibAn(produit.getLibAn());
            existingProduit.setUpdatedBy("admin");
            existingProduit.setUpdatedDate(LocalDateTime.now());
            existingProduit.setOperation("UPDATE PRODUCT");
            existingProduit.setUtilisateur("admin");

            return produitRepository.save(existingProduit);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }

    public void deleteProduit(Long id) {
        Optional<Produit> existingProduit = produitRepository.findById(id);
        if (existingProduit.isPresent()) {
            Produit produit = existingProduit.get();
            produit.setIsDeleted(1);
            produit.setUpdatedBy("admin");
            produit.setUpdatedDate(LocalDateTime.now());
            produit.setOperation("DELETE PRODUCT");
            produit.setUtilisateur("admin");

            produitRepository.save(produit);
        } else {
            throw new RessourceNotFoundException("Product with ID " + id + " not found.");
        }
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Product with ID " + id + " not found.")
        );
    }
}




