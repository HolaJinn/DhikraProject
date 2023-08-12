package com.example.backend.springbootbackend.repository;
import com.example.backend.springbootbackend.domain.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatistiqueRepository extends JpaRepository<Statistique,Long> {
}
