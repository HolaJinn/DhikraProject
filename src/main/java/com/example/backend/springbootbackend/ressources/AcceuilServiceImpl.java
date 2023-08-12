package com.example.backend.springbootbackend.ressources;

import com.example.backend.springbootbackend.domain.Acceuil;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.AcceuilRepository;
import com.example.backend.springbootbackend.services.AcceuilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AcceuilServiceImpl implements AcceuilService {
    @Autowired
    private AcceuilRepository acceuilRepository;


    public List<Acceuil> getAllAcceuil(){
        return acceuilRepository.findAll();
    }
    public Acceuil createAcceuil( Acceuil acceuil) {
        acceuil.setCreatedBy("admin");
        acceuil.setCreatedDate(LocalDateTime.now());
        acceuil.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        acceuil.setOperation("SAVE ACCEUIL");
        acceuil.setUtilisateur("admin");
        return acceuilRepository.save(acceuil);
    }

    public Acceuil updateAcceuil(Acceuil acceuil) {
        Acceuil existingAcceuil = acceuilRepository.findById(acceuil.getId()).orElse(null);

        if (existingAcceuil != null) {
            existingAcceuil.setLibAr(acceuil.getLibAr());
            existingAcceuil.setLibFr(acceuil.getLibFr());
            existingAcceuil.setLibAn(acceuil.getLibAn());
            existingAcceuil.setUpdatedBy("admin");
            existingAcceuil.setUpdatedDate(LocalDateTime.now());
            existingAcceuil.setOperation("UPDATE ACCEUIL");
            existingAcceuil.setUtilisateur("admin");

            return acceuilRepository.save(existingAcceuil);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }

    public void deleteAcceuil(Long id) {
        Optional<Acceuil> existingAcceuil = acceuilRepository.findById(id);
        if (existingAcceuil.isPresent()) {
            Acceuil acceuil = existingAcceuil.get();
            acceuil.setIsDeleted(1);
            acceuil.setUpdatedBy("admin");
            acceuil.setUpdatedDate(LocalDateTime.now());
            acceuil.setOperation("DELETE ACCEUIL");
            acceuil.setUtilisateur("admin");

            acceuilRepository.save(acceuil);
        } else {
            throw new RessourceNotFoundException("Acceuil with ID " + id + " not found.");
        }
    }

    public Acceuil getAcceuilById(Long id) {
        return acceuilRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Acceuil  with ID " + id + " not found.")
        );
    }
}
