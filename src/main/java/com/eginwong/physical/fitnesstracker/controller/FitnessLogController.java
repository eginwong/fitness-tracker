package com.eginwong.physical.fitnesstracker.controller;

import com.eginwong.physical.fitnesstracker.domain.FitnessLog;
import com.eginwong.physical.fitnesstracker.repository.FitnessLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Fitness log controller.
 */
@RestController
@RequestMapping("/api")
public class FitnessLogController {
    private FitnessLogRepository fitnessLogRepository;

    /**
     * Instantiates a new Fitness log controller.
     *
     * @param fitnessLogRepository the fitness log repository
     */
    public FitnessLogController(FitnessLogRepository fitnessLogRepository) {
        this.fitnessLogRepository = fitnessLogRepository;
    }

    /**
     * Retrieve all fitness logs list.
     *
     * @return the list
     */
    @GetMapping("/fitness-logs")
    public List<FitnessLog> retrieveAllFitnessLogs() {
        return new ArrayList<>(fitnessLogRepository.findAll());
    }
}
