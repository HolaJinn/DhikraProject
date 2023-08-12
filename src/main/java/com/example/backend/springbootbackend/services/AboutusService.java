package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.AboutUs;


import java.util.List;

public interface AboutusService {
    List<AboutUs> getAllAboutUs();
    AboutUs createAboutUs(AboutUs aboutUs);
    AboutUs updateAboutUs(AboutUs aboutUs);
    void deleteAboutUs(Long id);
    AboutUs getAboutUsById(Long id);
}
