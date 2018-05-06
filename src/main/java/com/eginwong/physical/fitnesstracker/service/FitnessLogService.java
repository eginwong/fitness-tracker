package com.eginwong.physical.fitnesstracker.service;

import com.eginwong.physical.fitnesstracker.configuration.ConversionConfiguration;
import com.eginwong.physical.fitnesstracker.domain.ConversionType;
import com.eginwong.physical.fitnesstracker.domain.FitnessLog;
import com.eginwong.physical.fitnesstracker.repository.FitnessLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Fitness log service.
 */
@Service
public class FitnessLogService {
    private static final double KG_TO_LBS = 2.20462;
    private FitnessLogRepository fitnessLogRepository;
    private ConversionConfiguration conversionConfiguration;

    /**
     * Instantiates a new Fitness log service.
     *
     * @param fitnessLogRepository    the fitness log repository
     * @param conversionConfiguration the conversion configuration
     */
    public FitnessLogService(FitnessLogRepository fitnessLogRepository, ConversionConfiguration conversionConfiguration) {
        this.fitnessLogRepository = fitnessLogRepository;
        this.conversionConfiguration = conversionConfiguration;
    }

    /**
     * Retrieve fitness logs list.
     *
     * @return the list
     */
    public List<FitnessLog> retrieveFitnessLogs() {
        if (conversionConfiguration == null) {
            throw new IllegalStateException("Null configuration for conversion type");
        }

        // imperial conversion, which is default
        if (conversionConfiguration.getType().equals(ConversionType.IMPERIAL)) {
            return fitnessLogRepository.findAll();
        }

        // metric conversion! must handle null case
        return fitnessLogRepository.findAll()
                .stream()
                .peek(x -> {
                    if (x.getWeight() != null) {
                        x.setWeight(x.getWeight() / KG_TO_LBS);
                    }
                })
                .collect(Collectors.toList());
    }
}
