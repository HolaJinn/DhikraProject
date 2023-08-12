package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.References;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ReferencesRepository;
import com.example.backend.springbootbackend.services.dto.ReferenceDTO;
import com.example.backend.springbootbackend.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Ref;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class ReferencesServiceImpl implements ReferencesService{
    @Autowired
    private ReferencesRepository referencesRepository;


    public List<References> getAllReferences(){
        return referencesRepository.findAll();
    }

    public References createReferences(ReferenceDTO reference) throws IOException {
        References references = new References();
        references.setCreatedBy("admin");
        references.setCreatedDate(LocalDateTime.now());
        references.setIsDeleted(0);
        references.setImage(ImageUtil.compressImage(reference.getImage().getBytes()));
        references.setOperation("SAVE REFERENCES");
        references.setUtilisateur("admin");
        return referencesRepository.save(references);
    }



    public References updateReferences(References references) {
        References existingReferences = referencesRepository.findById(references.getId()).orElse(null);

        if (existingReferences != null) {
            existingReferences.setNomAr(references.getNomAr());
            existingReferences.setNomFr(references.getNomFr());
            existingReferences.setNomAn(references.getNomAn());
            existingReferences.setImage(references.getImage());
            existingReferences.setUpdatedBy("admin");
            existingReferences.setUpdatedDate(LocalDateTime.now());
            existingReferences.setOperation("UPDATE PRODUCT");
            existingReferences.setUtilisateur("admin");

            return referencesRepository.save(existingReferences);
        } else {
            // Gérer le cas où lrefernce n'existe pas
            return null;
        }
    }

    public void deleteReferences(Long id) {
        Optional<References> existingReferences = referencesRepository.findById(id);
        if (existingReferences.isPresent()) {
            References references = existingReferences.get();
            references.setIsDeleted(1);
            references.setUpdatedBy("admin");
            references.setUpdatedDate(LocalDateTime.now());
            references.setOperation("DELETE References");
            references.setUtilisateur("admin");

            referencesRepository.save(references);
        } else {
            throw new RessourceNotFoundException("References with ID " + id + " not found.");
        }
    }

    public References getReferencesById(Long id) {

        References references = referencesRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("References with ID " + id + " not found.")
        );
        references.setImage(ImageUtil.decompressImage(references.getImage()));
        return references;
    }

    public byte[] getImage (Long refId) {
        References references = referencesRepository.findById(refId).orElseThrow(
                () -> new RessourceNotFoundException("References with ID " + refId + " not found.")
        );

        byte[] image = ImageUtil.decompressImage(references.getImage());
        return image;
    }
}
