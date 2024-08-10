package com.project.dashboard.service;


import com.project.dashboard.entity.Profile;
import com.project.dashboard.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> searchProfiles(String query) {
        return profileRepository.findByfirstNameContainingIgnoreCase(query);
    }
}
