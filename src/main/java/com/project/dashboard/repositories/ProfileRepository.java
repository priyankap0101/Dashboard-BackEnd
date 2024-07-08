package com.project.dashboard.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dashboard.entity.Profile;


public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
}
