package com.eginwong.physical.fitnesstracker.controller;

import com.eginwong.physical.fitnesstracker.domain.FitnessLog;
import com.eginwong.physical.fitnesstracker.repository.FitnessLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FitnessLogController {
    private FitnessLogRepository fitnessLogRepository;

    public FitnessLogController(FitnessLogRepository fitnessLogRepository) {
        this.fitnessLogRepository = fitnessLogRepository;
    }

    @GetMapping("/fitness-logs")
    public List<FitnessLog> retrieveAllFitnessLogs() {
        return new ArrayList<>(fitnessLogRepository.findAll());
    }
}
