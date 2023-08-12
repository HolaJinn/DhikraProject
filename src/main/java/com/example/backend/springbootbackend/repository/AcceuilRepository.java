package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.Acceuil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceuilRepository extends JpaRepository<Acceuil,Long> {
}
