package com.eginwong.physical.fitnesstracker.controller;

import com.eginwong.physical.fitnesstracker.configuration.ConversionConfiguration;
import com.eginwong.physical.fitnesstracker.domain.ConversionType;
import com.eginwong.physical.fitnesstracker.service.ConversionConfigurationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(ConfigurationController.class)
public class ConfigurationControllerTest {

    @MockBean
    private ConversionConfigurationService conversionConfigurationService;
    @MockBean
    private ConversionConfiguration conversionConfiguration;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        conversionConfiguration = new ConversionConfiguration();
        conversionConfigurationService = new ConversionConfigurationService(conversionConfiguration);
    }

    @Test
    public void change_conversion_configuration_imperial() throws Exception {
        mockMvc.perform(post("/api/configuration/conversion?type=lbs"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
    }

    @Test
    public void change_conversion_configuration_metric() throws Exception {
        conversionConfigurationService.toggle("METRIC");
        mockMvc.perform(post("/api/configuration/conversion?type=metric"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
    }

    @Test
    public void change_conversion_configuration_toggle() throws Exception {
        conversionConfigurationService.toggle();
        mockMvc.perform(post("/api/configuration/conversion"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
    }

    @Test
    public void change_conversion_configuration_toggle_bad_input() throws Exception {
        conversionConfigurationService.toggle("ADADSAD");
        mockMvc.perform(post("/api/configuration/conversion"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
    }
}