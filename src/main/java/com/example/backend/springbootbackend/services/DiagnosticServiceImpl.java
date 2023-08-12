package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Diagnostic;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.DiagnosticRepository;
import com.example.backend.springbootbackend.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class DiagnosticServiceImpl implements DiagnosticService{
    @Autowired
    private DiagnosticRepository diagnosticRepository ;


    public List<Diagnostic> getAllDiagnostic(){
        return diagnosticRepository.findAll();
    }
    public Diagnostic createDiagnostic( Diagnostic diagnostic) {
        diagnostic.setCreatedBy("admin");
        diagnostic.setCreatedDate(LocalDateTime.now());
        diagnostic.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        diagnostic.setOperation("SAVE DIAGNOSTIC");
        diagnostic.setUtilisateur("admin");
        return diagnosticRepository.save(diagnostic);
    }

    public Diagnostic updateDiagnostic(Diagnostic diagnostic) {
        Diagnostic existingDiagnostic = diagnosticRepository.findById(diagnostic.getId()).orElse(null);

        if (existingDiagnostic != null) {
            existingDiagnostic.setTitre(diagnostic.getTitre());
            existingDiagnostic.setLibAr(diagnostic.getLibAr());
            existingDiagnostic.setLibFr(diagnostic.getLibFr());
            existingDiagnostic.setLibAn(diagnostic.getLibAn());
            existingDiagnostic.setUpdatedBy("admin");
            existingDiagnostic.setUpdatedDate(LocalDateTime.now());
            existingDiagnostic.setOperation("UPDATE DIAGNOSTIC");
            existingDiagnostic.setUtilisateur("admin");

            return diagnosticRepository.save(existingDiagnostic);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }

    public void deleteDiagnostic(Long id) {
        Optional<Diagnostic> existingDiagnostic = diagnosticRepository.findById(id);
        if (existingDiagnostic.isPresent()) {
            Diagnostic diagnostic = existingDiagnostic.get();
            diagnostic.setIsDeleted(1);
            diagnostic.setUpdatedBy("admin");
            diagnostic.setUpdatedDate(LocalDateTime.now());
            diagnostic.setOperation("DELETE DIAGNOSTIC");
            diagnostic.setUtilisateur("admin");

            diagnosticRepository.save(diagnostic);
        } else {
            throw new RessourceNotFoundException("Diagnostic with ID " + id + " not found.");
        }
    }

    public Diagnostic getDiagnosticById(Long id) {
        return diagnosticRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Diagnostic with ID " + id + " not found.")
        );
    }
}
