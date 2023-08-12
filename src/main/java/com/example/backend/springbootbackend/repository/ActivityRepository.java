package com.example.backend.springbootbackend.repository;

import com.example.backend.springbootbackend.domain.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activities,Long> {
}
