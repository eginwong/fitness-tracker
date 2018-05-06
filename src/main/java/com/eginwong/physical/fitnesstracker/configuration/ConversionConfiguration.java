package com.eginwong.physical.fitnesstracker.configuration;

import com.eginwong.physical.fitnesstracker.domain.ConversionType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * The Conversion configuration will set attributes related to conversion.
 */
@Component
@ConfigurationProperties("conversion")
public class ConversionConfiguration {

    private static final List<String> METRIC = Arrays.asList("METRIC", "KILOGRAMS", "KILOGRAM", "KILOS", "KILO", "KGS", "KG");
    private static final List<String> IMPERIAL = Arrays.asList("IMPERIAL", "POUNDS", "POUND", "LBS", "LB");

    private ConversionType type;

    /**
     * Instantiates a new Conversion configuration.
     */
    public ConversionConfiguration() {
        this.type = ConversionType.IMPERIAL;
    }

    /**
     * Sets type via String parameter, associated with a predefined set of keywords.
     *
     * @param conversionType the conversion type
     * @throws IllegalStateException the illegal state exception when input is bad
     */
    public void setType(String conversionType) {
        if (conversionType == null) throw new IllegalStateException("Null input for conversion type");
        if (METRIC.contains(conversionType.toUpperCase())) this.type = ConversionType.METRIC;
        if (IMPERIAL.contains(conversionType.toUpperCase())) this.type = ConversionType.IMPERIAL;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public ConversionType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(ConversionType type) {
        this.type = type;
    }
}
