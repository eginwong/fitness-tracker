package com.eginwong.physical.fitnesstracker.service;

import com.eginwong.physical.fitnesstracker.configuration.ConversionConfiguration;
import com.eginwong.physical.fitnesstracker.domain.FitnessLog;
import com.eginwong.physical.fitnesstracker.repository.FitnessLogRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;

@RunWith(SpringRunner.class)
public class FitnessLogServiceTest {

    private static final double KG_TO_LBS = 2.20462;

    @MockBean
    private FitnessLogRepository fitnessLogRepository;
    @MockBean
    private ConversionConfiguration conversionConfiguration;

    private FitnessLogService fitnessLogService;
    private FitnessLog originalFitnessLog;
    private FitnessLog expectedFitnessLog;

    @Before
    public void setUp() {
        conversionConfiguration = new ConversionConfiguration();
        originalFitnessLog = new FitnessLog();
        expectedFitnessLog = new FitnessLog();
        modifyFitnessLog(originalFitnessLog);
        modifyFitnessLog(expectedFitnessLog);
        fitnessLogService = new FitnessLogService(fitnessLogRepository, conversionConfiguration);
    }

    private void modifyFitnessLog(FitnessLog fitnessLog) {
        fitnessLog.setCrunches(10);
        fitnessLog.setPullups(100);
        fitnessLog.setPushups(200);
        fitnessLog.setSupermans(50);
        fitnessLog.setWeight(160.2);
        fitnessLog.setLogDate(LocalDate.of(2018, 1, 1));
    }

    @Test
    public void retrieve_all_fitness_logs_lbs() {
        Mockito.when(fitnessLogRepository.findAll()).thenReturn(Collections.singletonList(originalFitnessLog));
        Assert.assertEquals(Collections.singletonList(expectedFitnessLog), fitnessLogService.retrieveFitnessLogs());
    }

    @Test
    public void retrieve_all_fitness_logs_kgs() {
        conversionConfiguration.setType("METRIC");
        expectedFitnessLog.setWeight(originalFitnessLog.getWeight() / KG_TO_LBS);

        Mockito.when(fitnessLogRepository.findAll()).thenReturn(Collections.singletonList(originalFitnessLog));

        Assert.assertEquals(Collections.singletonList(expectedFitnessLog), fitnessLogService.retrieveFitnessLogs());
    }

    @Test
    public void retrieve_all_fitness_logs_kgs_with_null() {
        conversionConfiguration.setType("METRIC");
        originalFitnessLog.setWeight(null);
        expectedFitnessLog.setWeight(null);
        Mockito.when(fitnessLogRepository.findAll()).thenReturn(Collections.singletonList(originalFitnessLog));
        Assert.assertEquals(Collections.singletonList(expectedFitnessLog), fitnessLogService.retrieveFitnessLogs());
    }
}