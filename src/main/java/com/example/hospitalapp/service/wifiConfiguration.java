package com.example.hospitalapp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class wifiConfiguration {

    

    @Bean
    public WifiProperties wifiProperties(){
        return new WifiProperties();
    }
}
