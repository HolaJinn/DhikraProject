package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Expertise;


import java.util.List;

public interface ExpertiseService {
    List<Expertise> getAllExpertise();
    Expertise createExpertise(Expertise expertise);
    Expertise updateExpertise(Expertise expertise);
    void deleteExpertise(Long id);
    Expertise getExpertiseById(Long id);
}
