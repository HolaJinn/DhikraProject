package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Acceuil;
import java.util.List;

public interface AcceuilService {
    List<Acceuil> getAllAcceuil();
    Acceuil createAcceuil(Acceuil acceuil);
    Acceuil updateAcceuil(Acceuil acceuil);
    void deleteAcceuil(Long id);
    Acceuil getAcceuilById(Long id);
}
