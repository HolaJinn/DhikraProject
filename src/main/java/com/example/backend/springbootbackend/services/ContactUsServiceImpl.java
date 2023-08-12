package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.ContactUs;

import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactUsServiceImpl implements ContactUsService{
    @Autowired
    private ContactUsRepository contactUsRepository ;


    public List<ContactUs> getAllContactUs(){
        return contactUsRepository.findAll();
    }
    public ContactUs createContactUs( ContactUs contactUs) {
        contactUs.setCreatedBy("admin");
        contactUs.setCreatedDate(LocalDateTime.now());
        contactUs.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        contactUs.setOperation("SAVE CONTACTUS");
        contactUs.setUtilisateur("admin");
        return contactUsRepository.save(contactUs);
    }

    public ContactUs updateContactUs(ContactUs contactUs) {
        ContactUs existingContactUs = contactUsRepository.findById(contactUs.getId()).orElse(null);

        if (existingContactUs != null) {
            existingContactUs.setFullName(contactUs.getFullName());
            existingContactUs.setEmail(contactUs.getEmail());
            existingContactUs.setPhone(contactUs.getPhone());
            existingContactUs.setDescription(contactUs.getDescription());
            existingContactUs.setUpdatedBy("admin");
            existingContactUs.setUpdatedDate(LocalDateTime.now());
            existingContactUs.setOperation("UPDATE CONTACTUS");
            existingContactUs.setUtilisateur("admin");

            return contactUsRepository.save(existingContactUs);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }
    public void deleteContactUs(Long id) {
        Optional<ContactUs> existingContactUs = contactUsRepository.findById(id);
        if (existingContactUs.isPresent()) {
            ContactUs contactUs = existingContactUs.get();
            contactUs.setIsDeleted(1);
            contactUs.setUpdatedBy("admin");
            contactUs.setUpdatedDate(LocalDateTime.now());
            contactUs.setOperation("DELETE CONTACTUS");
            contactUs.setUtilisateur("admin");

            contactUsRepository.save(contactUs);
        } else {
            throw new RessourceNotFoundException("Contactus with ID " + id + " not found.");
        }
    }

    public ContactUs getContactUsById(Long id) {
        return contactUsRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("ContactUs with ID " + id + " not found.")
        );
    }

}
