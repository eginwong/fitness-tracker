package com.eginwong.physical.fitnesstracker.controller;

import com.eginwong.physical.fitnesstracker.service.ConversionConfigurationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConfigurationController {

    private ConversionConfigurationService conversionConfigurationService;

    public ConfigurationController(ConversionConfigurationService conversionConfigurationService) {
        this.conversionConfigurationService = conversionConfigurationService;
    }

    @PostMapping("/configuration/conversion")
    public void updateConversionType(@RequestParam(value = "type", required = false) String type) {
        if (type != null) {
            conversionConfigurationService.toggle(type);
        } else {
            conversionConfigurationService.toggle();
        }
    }
}