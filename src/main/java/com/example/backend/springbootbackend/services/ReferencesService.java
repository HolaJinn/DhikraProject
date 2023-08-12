package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.References;
import com.example.backend.springbootbackend.services.dto.ReferenceDTO;

import java.io.IOException;
import java.util.List;

public interface ReferencesService {
    List<References> getAllReferences();
    References createReferences(ReferenceDTO reference) throws IOException;
    References updateReferences(References references);
    void deleteReferences(Long id);
    References getReferencesById(Long id);
    byte[] getImage(Long id);
}
