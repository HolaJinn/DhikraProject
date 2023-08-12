package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Diagnostic;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.DiagnosticService;
import com.example.backend.springbootbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DiagnosticController {
    @Autowired
    DiagnosticService diagnosticService;

    @GetMapping(value = "/diagnostic")
    public List<Diagnostic> getAllDiagnostic() {
        return diagnosticService.getAllDiagnostic();
    }

    @PostMapping("/diagnostic")
    public Diagnostic createDiagnostic(@RequestBody Diagnostic diagnostic) {
        return diagnosticService.createDiagnostic(diagnostic);
    }

    @PutMapping("/diagnostic/{id}")
    public Diagnostic updateDiagnostic(@PathVariable Long id, @RequestBody Diagnostic diagnostic) {
        diagnostic.setId(id);
        Diagnostic updateDiagnostic = diagnosticService.updateDiagnostic(diagnostic);
        if (updateDiagnostic == null) {
            throw new RessourceNotFoundException("Diagnostic with ID " + id + " not found.");
        }
        return updateDiagnostic;
    }

    @DeleteMapping("/diagnostic/{id}")
    public void deleteDiagnostic(@PathVariable Long id) {
        diagnosticService.deleteDiagnostic(id);
    }
    @GetMapping("/diagnostic/{id}")
    public Diagnostic getDiagnosticById(@PathVariable Long id) {
        return diagnosticService.getDiagnosticById(id);
    }
}
