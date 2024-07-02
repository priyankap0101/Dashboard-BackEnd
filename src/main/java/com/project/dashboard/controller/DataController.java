package com.project.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.dashboard.config.responseStructre;
import com.project.dashboard.entity.Data;
import com.project.dashboard.service.DataService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    // Endpoint to create a new data record
    @PostMapping("/data")
    public ResponseEntity<responseStructre<List<Data>>> saveData(@RequestBody List<Data> newDataList) {
        return dataService.saveData(newDataList);
    }

    // Endpoint to update an existing data record
    @PutMapping("/{id}")
    public ResponseEntity<responseStructre<Data>> updateData(@PathVariable Long id, @RequestBody Data newData) {
        responseStructre<Data> updatedData = dataService.updateData(id, newData);
        return ResponseEntity.ok(updatedData);
    }

    // Endpoint to retrieve all data records
    @GetMapping
    public ResponseEntity<List<Data>> getAllData() {
        List<Data> allData = dataService.getAllData();
        return new ResponseEntity<>(allData, HttpStatus.OK);
    }

    // Endpoint to retrieve a data record by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Data> getDataById(@PathVariable Long id) {
        Optional<Data> dataOptional = dataService.getDataById(id);
        return dataOptional.map(data -> new ResponseEntity<>(data, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to delete a data record by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDataById(@PathVariable Long id) {
        dataService.deleteDataById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // You can add more endpoints as needed
}

