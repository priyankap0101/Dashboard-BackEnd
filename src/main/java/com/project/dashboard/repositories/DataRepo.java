package com.project.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dashboard.entity.Data;

import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DataRepo extends JpaRepository<Data, Long> {
}

