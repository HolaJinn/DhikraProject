package com.example.backend.springbootbackend.services;
import com.example.backend.springbootbackend.domain.Statistique;

import java.util.List;

public interface StatistiqueService {
    List<Statistique> getAllStatistique();
    Statistique createStatistique(Statistique statistique);
    Statistique updateStatistique(Statistique statistique);
    void deleteStatistique(Long id);
    Statistique getStatistiqueById(Long id);
}
