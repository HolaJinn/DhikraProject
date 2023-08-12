package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUsRepository extends JpaRepository<AboutUs,Long> {
}
