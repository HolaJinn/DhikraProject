package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Expertise;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ExpertiseRepository;
import com.example.backend.springbootbackend.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpertiseServiceImpl implements ExpertiseService{
    @Autowired
    private ExpertiseRepository expertiseRepository;


    public List<Expertise> getAllExpertise(){
        return expertiseRepository.findAll();
    }
    public Expertise createExpertise( Expertise expertise) {
        expertise.setCreatedBy("admin");
        expertise.setCreatedDate(LocalDateTime.now());
        expertise.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        expertise.setOperation("SAVE EXPERTISE");
        expertise.setUtilisateur("admin");
        return expertiseRepository.save(expertise);
    }

    public Expertise updateExpertise(Expertise expertise) {
        Expertise existingExpertise = expertiseRepository.findById(expertise.getId()).orElse(null);

        if (existingExpertise != null) {
            existingExpertise.setLibAr(expertise.getLibAr());
            existingExpertise.setLibFr(expertise.getLibFr());
            existingExpertise.setLibAn(expertise.getLibAn());
            existingExpertise.setUpdatedBy("admin");
            existingExpertise.setUpdatedDate(LocalDateTime.now());
            existingExpertise.setOperation("UPDATE EXPERTISE");
            existingExpertise.setUtilisateur("admin");

            return expertiseRepository.save(existingExpertise);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }

    public void deleteExpertise(Long id) {
        Optional<Expertise> existingExpertise = expertiseRepository.findById(id);
        if (existingExpertise.isPresent()) {
            Expertise expertise = existingExpertise.get();
            expertise.setIsDeleted(1);
            expertise.setUpdatedBy("admin");
            expertise.setUpdatedDate(LocalDateTime.now());
            expertise.setOperation("DELETE EXPERTISE");
            expertise.setUtilisateur("admin");

            expertiseRepository.save(expertise);
        } else {
            throw new RessourceNotFoundException("Expertise with ID " + id + " not found.");
        }
    }

    public Expertise getExpertiseById(Long id) {
        return expertiseRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Expertise with ID " + id + " not found.")
        );
    }
}
