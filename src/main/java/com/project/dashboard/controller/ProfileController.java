package com.project.dashboard.controller;

import com.project.dashboard.entity.Profile;
import com.project.dashboard.service.ProfileService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostMapping("/register")
//    public ResponseEntity<Profile> registerProfile(@RequestBody Profile profile) {
//        profile.setPassword((profile.getPassword()));
//        Profile savedProfile = profileService.saveProfile(profile);
//        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginProfile(@RequestBody Profile profile) {
//        Optional<Profile> existingProfile = profileService.getProfileByEmail(profile.getEmail());
//        if (existingProfile.isPresent() && passwordEncoder.matches(profile.getPassword(), existingProfile.get().getPassword())) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
//    }

    
    @PostMapping("/register")
    public ResponseEntity<Profile> registerProfile(@RequestBody Profile profile) {
        // Store the password as is (not recommended for production)
        Profile savedProfile = profileService.saveProfile(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginProfile(@RequestBody Profile profile) {
        Optional<Profile> existingProfile = profileService.getProfileByEmail(profile.getEmail());
        if (existingProfile.isPresent() && profile.getPassword().equals(existingProfile.get().getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @GetMapping("/getbyId")
    public ResponseEntity<Profile> getProfile(@RequestParam Long id) {
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
        List<Profile> allProfiles = profileService.getAllProfile();
        return new ResponseEntity<>(allProfiles, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchProfiles(@RequestParam String query) {
        List<Profile> profiles = profileService.searchProfiles(query);
        if (profiles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
  
}