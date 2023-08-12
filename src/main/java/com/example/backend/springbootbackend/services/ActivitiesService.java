package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Activities;
import com.example.backend.springbootbackend.domain.Produit;

import java.util.List;

public interface ActivitiesService {
    List<Activities> getAllActivities();
    Activities createActivities(Activities activities);
    Activities updateActivities(Activities activities);
    void deleteActivities(Long id);
    Activities getActivitiesById(Long id);
}
