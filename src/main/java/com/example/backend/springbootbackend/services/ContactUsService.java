package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.ContactUs;


import java.util.List;

public interface ContactUsService {
    List<ContactUs> getAllContactUs();
    ContactUs createContactUs(ContactUs contactUs);
    ContactUs updateContactUs(ContactUs contactUs);
    void deleteContactUs(Long id);
    ContactUs getContactUsById(Long id);
}
