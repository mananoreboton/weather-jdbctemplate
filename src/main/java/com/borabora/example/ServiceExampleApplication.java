package com.borabora.example;

import com.borabora.example.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ServiceExampleApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(ServiceExampleApplication.class);

    @Autowired
    WeatherRepository weatherRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServiceExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        weatherRepository.createWeatherSampleTable();
        logger.info("Weather samples table created");
    }
}
