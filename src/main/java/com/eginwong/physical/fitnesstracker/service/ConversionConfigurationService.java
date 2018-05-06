package com.eginwong.physical.fitnesstracker.service;

import com.eginwong.physical.fitnesstracker.configuration.ConversionConfiguration;
import com.eginwong.physical.fitnesstracker.domain.ConversionType;
import org.springframework.stereotype.Service;

/**
 * The type Conversion configuration service.
 */
@Service
public class ConversionConfigurationService {
    private ConversionConfiguration conversionConfiguration;

    /**
     * Instantiates a new Conversion configuration service.
     *
     * @param conversionConfiguration the conversion configuration
     */
    public ConversionConfigurationService(ConversionConfiguration conversionConfiguration) {
        this.conversionConfiguration = conversionConfiguration;
    }

    /**
     * Toggle based on a string.
     *
     * @param setting the setting
     */
    public void toggle(String setting) {
        conversionConfiguration.setType(setting);
    }

    /**
     * Toggle between the two possible choices.
     */
    public void toggle() {
        if (conversionConfiguration.getType().equals(ConversionType.IMPERIAL)) {
            conversionConfiguration.setType(ConversionType.METRIC);
        } else {
            conversionConfiguration.setType(ConversionType.IMPERIAL);
        }
    }
}
