package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.ContactInfo;
import com.example.backend.springbootbackend.domain.ContactUs;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ContactInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ContactInfoController {
    @Autowired
    ContactInfoService contactInfoService;

    @GetMapping(value = "/contactinfo")
    public List<ContactInfo> getAllContactInfo() {
        return contactInfoService.getAllContactInfo();
    }

    @PostMapping("/contactinfo")
    public ContactInfo createContactInfo(@RequestBody ContactInfo contactInfo) {
        return contactInfoService.createContactInfo(contactInfo);
    }

    @PutMapping("/contactinfo/{id}")
    public ContactInfo updateContactInfo(@PathVariable Long id, @RequestBody ContactInfo contactInfo) {
        contactInfo.setId(id);
        ContactInfo updateContactInfo = contactInfoService.updateContactInfo(contactInfo);
        if (updateContactInfo == null) {
            throw new RessourceNotFoundException("Contactinfo with ID " + id + " not found.");
        }
        return updateContactInfo;
    }

    @DeleteMapping("/contactinfo/{id}")
    public void deleteContactInfo(@PathVariable Long id) {
        contactInfoService.deleteContactInfo(id);
    }
    @GetMapping("/contactinfo/{id}")
    public ContactInfo getContactInfoById(@PathVariable Long id) {
        return contactInfoService.getContactInfoById(id);
    }
}
