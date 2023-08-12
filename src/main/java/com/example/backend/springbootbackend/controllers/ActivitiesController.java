package com.example.backend.springbootbackend.controllers;

import com.example.backend.springbootbackend.domain.Activities;
import com.example.backend.springbootbackend.domain.Produit;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.services.ActivitiesService;
import com.example.backend.springbootbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ActivitiesController {
    @Autowired
    ActivitiesService activitiesService;

    @GetMapping(value = "/activities")
    public List<Activities> getAllActivities() {
        return activitiesService.getAllActivities();
    }

    @PostMapping("/activities")
    public Activities createActivities(@RequestBody Activities activities) {
        return activitiesService.createActivities(activities);
    }

    @PutMapping("/activities/{id}")
    public Activities updateActivities(@PathVariable Long id, @RequestBody Activities activities) {
        activities.setId(id);
        Activities updateActivities = activitiesService.updateActivities(activities);
        if (updateActivities == null) {
            throw new RessourceNotFoundException("Product with ID " + id + " not found.");
        }
        return updateActivities;
    }

    @DeleteMapping("/activities/{id}")
    public void deleteActivities(@PathVariable Long id) {
        activitiesService.deleteActivities(id);
    }
    @GetMapping("/activities/{id}")
    public Activities getActivitiesById(@PathVariable Long id) {
        return activitiesService.getActivitiesById(id);
    }
}
