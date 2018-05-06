package com.eginwong.physical.fitnesstracker.controller;

import com.eginwong.physical.fitnesstracker.domain.FitnessLog;
import com.eginwong.physical.fitnesstracker.service.FitnessLogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(FitnessLogController.class)
public class FitnessLogControllerTest {

    @MockBean
    private FitnessLogService fitnessLogService;
    @Autowired
    private MockMvc mockMvc;

    private FitnessLog fitnessLog;

    @Before
    public void setup() {
        fitnessLog = new FitnessLog();
        modifyFitnessLog(fitnessLog);
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
    public void retrieve_all_fitness_logs() throws Exception {

        Mockito.when(fitnessLogService.retrieveFitnessLogs()).thenReturn(Collections.singletonList(fitnessLog));
        mockMvc.perform(get("/api/fitness-logs"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].crunches").value(fitnessLog.getCrunches()))
                .andExpect(jsonPath("$.[0].pullups").value(fitnessLog.getPullups()))
                .andExpect(jsonPath("$.[0].pushups").value(fitnessLog.getPushups()))
                .andExpect(jsonPath("$.[0].supermans").value(fitnessLog.getSupermans()))
                .andExpect(jsonPath("$.[0].weight").value(fitnessLog.getWeight()))
                .andExpect(jsonPath("$.[0].logDate").value(fitnessLog.getLogDate().toString()));
    }

    @Test
    public void update_conversion_configuration() throws Exception {

        Mockito.when(fitnessLogService.retrieveFitnessLogs()).thenReturn(Collections.singletonList(fitnessLog));
        mockMvc.perform(get("/api/fitness-logs"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].crunches").value(fitnessLog.getCrunches()))
                .andExpect(jsonPath("$.[0].pullups").value(fitnessLog.getPullups()))
                .andExpect(jsonPath("$.[0].pushups").value(fitnessLog.getPushups()))
                .andExpect(jsonPath("$.[0].supermans").value(fitnessLog.getSupermans()))
                .andExpect(jsonPath("$.[0].weight").value(fitnessLog.getWeight()))
                .andExpect(jsonPath("$.[0].logDate").value(fitnessLog.getLogDate().toString()));
    }
}