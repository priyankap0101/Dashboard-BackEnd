package com.project.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.dashboard.entity.Profile;
import com.project.dashboard.service.ProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Endpoint to create a new data record
    @PostMapping
    public Profile saveEntity(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);
    }

    @GetMapping("/getbyId/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable Long id) {
        Optional<Profile> profile = profileService.getProfile(id);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        if (profile.getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        Profile updatedProfile = profileService.saveOrUpdateProfile(profile);
        return ResponseEntity.ok(updatedProfile);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> allProfile = profileService.getAllProfile();
        return new ResponseEntity<>(allProfile, HttpStatus.OK);
    }
}
