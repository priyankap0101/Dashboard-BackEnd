package com.project.dashboard.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.Profiles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.dashboard.config.responseStructre;
import com.project.dashboard.entity.Data;
import com.project.dashboard.entity.Profile;
import com.project.dashboard.service.ProfileService;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    
    
    // Endpoint to create a new data record
    @PostMapping("/profile")
    public Profile saveEntity(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);
    }

    @GetMapping("/getProfile/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        Optional<Profile> profile = profileService.getProfile(id);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/updateProfile")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        Profile updatedProfile = profileService.saveOrUpdateProfile(profile);
        return ResponseEntity.ok(updatedProfile);
    }
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> allProfile = profileService.getAllProfile();
        return new ResponseEntity<>(allProfile, HttpStatus.OK);
    }
}