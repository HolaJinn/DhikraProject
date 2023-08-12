package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.ContactInfo;


import java.util.List;

public interface ContactInfoService {
    List<ContactInfo> getAllContactInfo();
    ContactInfo createContactInfo(ContactInfo contactInfo);
    ContactInfo updateContactInfo(ContactInfo contactInfo);
    void deleteContactInfo(Long id);
    ContactInfo getContactInfoById(Long id);
}
