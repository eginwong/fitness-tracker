package com.eginwong.physical.fitnesstracker.configuration;

import com.eginwong.physical.fitnesstracker.domain.ConversionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class ConversionConfigurationTest {

    private ConversionConfiguration conversionConfiguration;

    @Before
    public void setup() {
        conversionConfiguration = new ConversionConfiguration();
    }

    @Test
    public void default_conversion_type() {
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
    }

    @Test
    public void set_type_metric() {
        conversionConfiguration.setType("METRIC");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("KG");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("KGS");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("KILOGRAM");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("KILOGRAMS");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("KILO");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("KILOS");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("kilos");
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
    }

    @Test
    public void set_type_imperial() {
        conversionConfiguration.setType("IMPERIAL");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("POUNDS");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("POUND");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("LBS");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("LB");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("lb");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
        conversionConfiguration = new ConversionConfiguration();
        conversionConfiguration.setType("lB");
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
    }

    @Test(expected = IllegalStateException.class)
    public void set_type_exception() {
        conversionConfiguration.setType((String) null);
    }

    @Test
    public void property_file_configuration_setting() {
        ReflectionTestUtils.setField(conversionConfiguration, "type", ConversionType.METRIC);
        Assert.assertEquals(ConversionType.METRIC, conversionConfiguration.getType());
        ReflectionTestUtils.setField(conversionConfiguration, "type", ConversionType.IMPERIAL);
        Assert.assertEquals(ConversionType.IMPERIAL, conversionConfiguration.getType());
    }
}