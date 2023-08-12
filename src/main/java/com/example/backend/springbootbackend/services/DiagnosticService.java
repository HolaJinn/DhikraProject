package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Diagnostic;
import com.example.backend.springbootbackend.domain.Produit;

import java.util.List;

public interface DiagnosticService {
    List<Diagnostic> getAllDiagnostic();
    Diagnostic createDiagnostic(Diagnostic diagnostic);
    Diagnostic updateDiagnostic(Diagnostic diagnostic);
    void deleteDiagnostic(Long id);
    Diagnostic getDiagnosticById(Long id);
}
