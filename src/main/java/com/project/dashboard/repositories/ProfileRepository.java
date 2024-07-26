package com.project.dashboard.repositories;

import com.project.dashboard.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(String email);
    List<Profile> findByfirstNameContainingIgnoreCase(String name);
}
