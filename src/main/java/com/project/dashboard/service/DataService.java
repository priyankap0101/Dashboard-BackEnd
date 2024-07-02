package com.project.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dashboard.config.responseStructre;
import com.project.dashboard.entity.Data;
import com.project.dashboard.repositories.DataRepo;

import java.util.List;
import java.util.Optional;

@Service
public class DataService {

    private final DataRepo dataRepository;

    @Autowired
    public DataService(DataRepo dataRepository) {
        this.dataRepository = dataRepository;
    }

    public ResponseEntity<responseStructre<List<Data>>> saveData(List<Data> newDataList) {
        responseStructre<List<Data>> response = new responseStructre<>();
        try {
            List<Data> savedDataList = dataRepository.saveAll(newDataList);
            response.setData(savedDataList);
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Data saved successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public responseStructre<Data> updateData(Long id, Data newData) {
        responseStructre<Data> response = new responseStructre<>();
        try {
            Optional<Data> existingDataOptional = dataRepository.findById(id);
            if (existingDataOptional.isPresent()) {
                Data existingData = existingDataOptional.get();
                existingData.setCity(newData.getCity());
                existingData.setCountry(newData.getCountry());
                existingData.setInsight(newData.getInsight());
                // Set other fields similarly...

                response.setData(dataRepository.save(existingData));
                response.setStatusCode(200);
                response.setMessage("Data updated successfully.");
            } else {
                response.setStatusCode(404);
                response.setMessage("Data with ID " + id + " not found.");
            }
        } catch (Exception e) {
            // Handle any exceptions
            response.setStatusCode(500);
            response.setMessage("Internal Server Error: " + e.getMessage());
        }
        return response;
    }

    // Method to retrieve all data records
    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    // Method to retrieve a data record by its ID
    public Optional<Data> getDataById(Long id) {
        return dataRepository.findById(id);
    }

    // Method to delete a data record by its ID
    public void deleteDataById(Long id) {
        dataRepository.deleteById(id);
    }
}
