package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.AboutUs;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.AboutUsRepository;
import com.example.backend.springbootbackend.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AboutUsServiceImpl implements AboutusService {

    @Autowired
    private AboutUsRepository aboutUsRepository;


    public List<AboutUs> getAllAboutUs(){
        return aboutUsRepository.findAll();
    }
    public AboutUs createAboutUs( AboutUs aboutUs) {
        aboutUs.setCreatedBy("admin");
        aboutUs.setCreatedDate(LocalDateTime.now());
        aboutUs.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        aboutUs.setOperation("SAVE ABOUT US");
        aboutUs.setUtilisateur("admin");
        return aboutUsRepository.save(aboutUs);
    }

    public AboutUs updateAboutUs(AboutUs aboutUs) {
        AboutUs existingAboutus = aboutUsRepository.findById(aboutUs.getId()).orElse(null);

        if (existingAboutus != null) {
            existingAboutus.setLibAr(aboutUs.getLibAr());
            existingAboutus.setLibFr(aboutUs.getLibFr());
            existingAboutus.setLibAn(aboutUs.getLibAn());
            existingAboutus.setUpdatedBy("admin");
            existingAboutus.setUpdatedDate(LocalDateTime.now());
            existingAboutus.setOperation("UPDATE PRODUCT");
            existingAboutus.setUtilisateur("admin");

            return aboutUsRepository.save(existingAboutus);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }

    public void deleteAboutUs(Long id) {
        Optional<AboutUs> existingAboutus = aboutUsRepository.findById(id);
        if (existingAboutus.isPresent()) {
            AboutUs aboutUs = existingAboutus.get();
            aboutUs.setIsDeleted(1);
            aboutUs.setUpdatedBy("admin");
            aboutUs.setUpdatedDate(LocalDateTime.now());
            aboutUs.setOperation("DELETE ABOUT US");
            aboutUs.setUtilisateur("admin");

            aboutUsRepository.save(aboutUs);
        } else {
            throw new RessourceNotFoundException("About us  with ID " + id + " not found.");
        }
    }

    public AboutUs getAboutUsById(Long id) {
        return aboutUsRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("About us  with ID " + id + " not found.")
        );
    }

}
