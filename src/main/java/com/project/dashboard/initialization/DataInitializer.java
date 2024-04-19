package com.project.dashboard.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.dashboard.entity.Data;
import com.project.dashboard.service.DataService;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DataService dataService;

    @Autowired
    public DataInitializer(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize sample data
//        List<Data> sampleData = Arrays.asList(
//            new Data(3, 4, 5, 2018, "Country1", "Topic1", "Region1", "City1", "Sector1", "Insight1", "SWOT1", "PESTLE1", "Source1", "URL1"),
//            new Data(4, 5, 3, 2019, "Country2", "Topic2", "Region2", "City2", "Sector2", "Insight2", "SWOT2", "PESTLE2", "Source2", "URL2")
//            // Add more sample data as needed
//        );

        // Save each sample data to the database using the provided DataService
//        for (Data data : sampleData) {
//            dataService.saveData(data);
//        }
    }
}
