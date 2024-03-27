package com.interid.config;

import com.interid.web.factory.AnimalFactory;
import com.interid.web.factory.BirdFactory;
import com.interid.web.factory.DogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Map<String, AnimalFactory> factoryMap() {
        Map<String, AnimalFactory> map = new HashMap<>();
        map.put("Собака", new DogFactory());
        map.put("Птица", new BirdFactory());

        // ...
        // ...
        // ...
        return map;
    }
}
