package com.eginwong.physical.fitnesstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * The Fitness Tracker application is to represent a simple enough problem to demonstrate basic fundamental
 * java programming.
 */
// needed in order to use LocalDate in the database
@EntityScan(basePackageClasses = {FitnessTrackerApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
public class FitnessTrackerApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(FitnessTrackerApplication.class, args);
    }

    /**
     * Log filter commons request logging filter.
     *
     * @return the commons request logging filter
     */
    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
                = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }
}
