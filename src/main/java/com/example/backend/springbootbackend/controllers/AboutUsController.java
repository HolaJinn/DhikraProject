package com.example.backend.springbootbackend.controllers;
import com.example.backend.springbootbackend.domain.AboutUs;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.AboutusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AboutUsController {
    @Autowired
    AboutusService aboutusService;

    @GetMapping(value = "/aboutus")
    public List<AboutUs> getAllAboutUs() {
        return aboutusService.getAllAboutUs();
    }

    @PostMapping("/aboutus")
    public AboutUs createAboutUs(@RequestBody AboutUs aboutUs) {
        return aboutusService.createAboutUs(aboutUs);
    }

    @PutMapping("/aboutus/{id}")
    public AboutUs updateAboutUs(@PathVariable Long id, @RequestBody AboutUs aboutUs) {
        aboutUs.setId(id);
        AboutUs updateAboutUs = aboutusService.updateAboutUs(aboutUs);
        if (updateAboutUs == null) {
            throw new RessourceNotFoundException("About us  with ID " + id + " not found.");
        }
        return updateAboutUs;
    }

    @DeleteMapping("/aboutus/{id}")
    public void deleteAboutUs(@PathVariable Long id) {
        aboutusService.deleteAboutUs(id);
    }
    @GetMapping("/aboutus/{id}")
    public AboutUs getAboutUsById(@PathVariable Long id) {
        return aboutusService.getAboutUsById(id);
    }
}
