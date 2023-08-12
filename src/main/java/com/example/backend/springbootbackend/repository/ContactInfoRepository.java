package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo,Long> {
}
