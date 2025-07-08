package com.example.hospitalapp.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("wifi")
public class WifiProperties {

    private Map<String,String> days;

    public Map<String,String> getDays() {
        return days;
    }

    public void setDays(Map<String,String> days) {
        this.days = days;
    }
}
