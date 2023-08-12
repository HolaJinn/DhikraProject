package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.ContactInfo;
import com.example.backend.springbootbackend.domain.ContactUs;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class ContactInfoServiceImpl implements ContactInfoService{
    @Autowired
    private ContactInfoRepository contactInfoRepository ;


    public List<ContactInfo> getAllContactInfo(){
        return contactInfoRepository.findAll();
    }
    public ContactInfo createContactInfo( ContactInfo contactInfo) {
        contactInfo.setCreatedBy("admin");
        contactInfo.setCreatedDate(LocalDateTime.now());
        contactInfo.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        contactInfo.setOperation("SAVE CONTACTINFO");
        contactInfo.setUtilisateur("admin");
        return contactInfoRepository.save(contactInfo);
    }

    public ContactInfo updateContactInfo(ContactInfo contactInfo) {
        ContactInfo existingContactInfo = contactInfoRepository.findById(contactInfo.getId()).orElse(null);

        if (existingContactInfo != null) {
            existingContactInfo.setPhone(contactInfo.getPhone());
            existingContactInfo.setFax(contactInfo.getFax());
            existingContactInfo.setAddress(contactInfo.getAddress());
            existingContactInfo.setEmail(contactInfo.getEmail());
            existingContactInfo.setUpdatedBy("admin");
            existingContactInfo.setUpdatedDate(LocalDateTime.now());
            existingContactInfo.setOperation("UPDATE CONTACINFO");
            existingContactInfo.setUtilisateur("admin");

            return contactInfoRepository.save(existingContactInfo);
        } else {
            // Gérer le cas où lecontactinfo n'existe pas
            return null;
        }
    }
    public void deleteContactInfo(Long id) {
        Optional<ContactInfo> existingContactInfo = contactInfoRepository.findById(id);
        if (existingContactInfo.isPresent()) {
            ContactInfo contactInfo = existingContactInfo.get();
            contactInfo.setIsDeleted(1);
            contactInfo.setUpdatedBy("admin");
            contactInfo.setUpdatedDate(LocalDateTime.now());
            contactInfo.setOperation("DELETE CONTACTINFO");
            contactInfo.setUtilisateur("admin");

            contactInfoRepository.save(contactInfo);
        } else {
            throw new RessourceNotFoundException("Contactinfo with ID " + id + " not found.");
        }
    }

    public ContactInfo getContactInfoById(Long id) {
        return contactInfoRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("ContactInfo with ID " + id + " not found.")
        );
    }

}
