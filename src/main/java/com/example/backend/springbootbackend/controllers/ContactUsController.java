package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.ContactUs;

import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ContactUsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ContactUsController {
    @Autowired
    ContactUsService contactUsService;

    @GetMapping(value = "/contactus")
    public List<ContactUs> getAllContactUs() {
        return contactUsService.getAllContactUs();
    }

    @PostMapping("/contactus")
    public ContactUs createContactUs(@RequestBody ContactUs contactUs) {
        return contactUsService.createContactUs(contactUs);
    }

    @PutMapping("/contactus/{id}")
    public ContactUs updateContactUs(@PathVariable Long id, @RequestBody ContactUs contactUs) {
        contactUs.setId(id);
        ContactUs updateContactUs = contactUsService.updateContactUs(contactUs);
        if (updateContactUs == null) {
            throw new RessourceNotFoundException("Contactus with ID " + id + " not found.");
        }
        return updateContactUs;
    }

    @DeleteMapping("/contactus/{id}")
    public void deleteContactUs(@PathVariable Long id) {
        contactUsService.deleteContactUs(id);
    }
    @GetMapping("/contactus/{id}")
    public ContactUs getContactUsById(@PathVariable Long id) {
        return contactUsService.getContactUsById(id);
    }
}
