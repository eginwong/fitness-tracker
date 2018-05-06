package com.eginwong.physical.fitnesstracker.controller;

import com.eginwong.physical.fitnesstracker.domain.FitnessLog;
import com.eginwong.physical.fitnesstracker.service.FitnessLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Fitness log controller.
 */
@RestController
@RequestMapping("/api")
public class FitnessLogController {

    private FitnessLogService fitnessLogService;

    /**
     * Instantiates a new Fitness log controller.
     *
     * @param fitnessLogService the fitness log service
     */
    public FitnessLogController(FitnessLogService fitnessLogService) {
        this.fitnessLogService = fitnessLogService;
    }

    /**
     * Retrieve all fitness logs list.
     *
     * @return the list
     */
    @GetMapping("/fitness-logs")
    public List<FitnessLog> retrieveAllFitnessLogs() {
        return fitnessLogService.retrieveFitnessLogs();
    }
}