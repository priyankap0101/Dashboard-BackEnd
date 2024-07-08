package com.project.dashboard.service;

import com.project.dashboard.config.responseStructre;
import com.project.dashboard.entity.Data;
import com.project.dashboard.entity.Profile;
import com.project.dashboard.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;
    
    public Profile saveProfile(Profile profile ) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfile(Long id) {
        return profileRepository.findById(id);
    }

    public Profile saveOrUpdateProfile(Profile profile) {
        return profileRepository.save(profile);
    }
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }
}
