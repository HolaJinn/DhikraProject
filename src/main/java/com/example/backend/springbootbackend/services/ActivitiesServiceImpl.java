package com.example.backend.springbootbackend.services;

import com.example.backend.springbootbackend.domain.Activities;
import com.example.backend.springbootbackend.exception.RessourceNotFoundException;
import com.example.backend.springbootbackend.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActivitiesServiceImpl implements ActivitiesService{
    @Autowired
    private ActivityRepository activityRepository;


    public List<Activities> getAllActivities(){
        return activityRepository.findAll();
    }
    public Activities createActivities( Activities activities) {
        activities.setCreatedBy("admin");
        activities.setCreatedDate(LocalDateTime.now());
        activities.setIsDeleted(0);
        //     produit.setUpdatedBy("admin");
        //    produit.setUpdatedDate(LocalDateTime.now());
        activities.setOperation("SAVE ACTIVITIES");
        activities.setUtilisateur("admin");
        return activityRepository.save(activities);
    }

    public Activities updateActivities(Activities activities) {
        Activities existingActivity = activityRepository.findById(activities.getId()).orElse(null);

        if (existingActivity != null) {
            existingActivity.setCode(activities.getCode());
            existingActivity.setLibAr(activities.getLibAr());
            existingActivity.setLibFr(activities.getLibFr());
            existingActivity.setLibAn(activities.getLibAn());
            existingActivity.setUpdatedBy("admin");
            existingActivity.setUpdatedDate(LocalDateTime.now());
            existingActivity.setOperation("UPDATE ACTIVITY");
            existingActivity.setUtilisateur("admin");

            return activityRepository.save(existingActivity);
        } else {
            // Gérer le cas où le produit n'existe pas
            return null;
        }
    }

    public void deleteActivities(Long id) {
        Optional<Activities> existingActivity = activityRepository.findById(id);
        if (existingActivity.isPresent()) {
            Activities activities = existingActivity.get();
            activities.setIsDeleted(1);
            activities.setUpdatedBy("admin");
            activities.setUpdatedDate(LocalDateTime.now());
            activities.setOperation("DELETE ACTIVITY");
            activities.setUtilisateur("admin");

            activityRepository.save(activities);
        } else {
            throw new RessourceNotFoundException("Activity with ID " + id + " not found.");
        }
    }

    public Activities getActivitiesById(Long id) {
        return activityRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Activity with ID " + id + " not found.")
        );
    }
}
