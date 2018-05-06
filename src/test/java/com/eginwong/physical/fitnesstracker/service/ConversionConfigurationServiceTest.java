package com.eginwong.physical.fitnesstracker.service;

import com.eginwong.physical.fitnesstracker.configuration.ConversionConfiguration;
import com.eginwong.physical.fitnesstracker.domain.ConversionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ConversionConfigurationServiceTest {

    @MockBean
    private ConversionConfiguration conversionConfiguration;

    private ConversionConfigurationService conversionConfigurationService;

    @Before
    public void setUp() {
        conversionConfiguration = new ConversionConfiguration();
        conversionConfigurationService = new ConversionConfigurationService(conversionConfiguration);
    }

    @Test
    public void toggle_metric() {
        conversionConfigurationService.toggle("METRIC");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
    }

    @Test
    public void toggle_imperial() {
        conversionConfigurationService.toggle("IMPERIAL");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
    }

    @Test
    public void toggle_plain() {
        // set starting point
        conversionConfigurationService.toggle("IMPERIAL");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
        conversionConfigurationService.toggle();
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfigurationService.toggle();
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
    }
}