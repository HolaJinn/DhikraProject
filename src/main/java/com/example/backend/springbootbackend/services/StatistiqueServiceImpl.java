package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.domain.Statistique;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ProduitRepository;
import com.example.backend.springbootbackend.repository.StatistiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StatistiqueServiceImpl implements StatistiqueService{
    @Autowired
    private StatistiqueRepository statistiqueRepository;


    public List<Statistique> getAllStatistique(){
        return statistiqueRepository.findAll();
    }
    public Statistique createStatistique( Statistique statistique) {
        statistique.setCreatedBy("admin");
        statistique.setCreatedDate(LocalDateTime.now());
        statistique.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        statistique.setOperation("SAVE STATISTIQUE");
        statistique.setUtilisateur("admin");
        return statistiqueRepository.save(statistique);
    }

    public Statistique updateStatistique(Statistique statistique ){
        Statistique existingStatistique = statistiqueRepository.findById(statistique.getId()).orElse(null);

        if (existingStatistique != null) {
            existingStatistique.setSubInWorld(statistique.getSubInWorld());
            existingStatistique.setCountry(statistique.getCountry());
            existingStatistique.setNbProject(statistique.getNbProject());
            existingStatistique.setCustomers(statistique.getCustomers());
            existingStatistique.setUpdatedBy("admin");
            existingStatistique.setUpdatedDate(LocalDateTime.now());
            existingStatistique.setOperation("UPDATE STATISTIQUE");
            existingStatistique.setUtilisateur("admin");

            return statistiqueRepository.save(existingStatistique);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }

    public void deleteStatistique(Long id) {
        Optional<Statistique> existingStatistique = statistiqueRepository.findById(id);
        if (existingStatistique.isPresent()) {
            Statistique statistique = existingStatistique.get();
            statistique.setIsDeleted(1);
            statistique.setUpdatedBy("admin");
            statistique.setUpdatedDate(LocalDateTime.now());
            statistique.setOperation("DELETE STATISTIQUE");
            statistique.setUtilisateur("admin");

            statistiqueRepository.save(statistique);
        } else {
            throw new RessourceNotFoundException("statistique with ID " + id + " not found.");
        }
    }

    public Statistique getStatistiqueById(Long id) {
        return statistiqueRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("statistique with ID " + id + " not found.")
        );
    }
}
