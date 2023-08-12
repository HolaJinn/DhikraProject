package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.References;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferencesRepository extends JpaRepository<References,Long> {
}
