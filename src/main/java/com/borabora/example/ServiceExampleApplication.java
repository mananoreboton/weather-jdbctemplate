package com.borabora.example;

import com.borabora.example.repository.WeatherRepository;
import com.borabora.example.repository.WeatherRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ServiceExampleApplication implements CommandLineRunner {

	@Autowired
	WeatherRepository weatherRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServiceExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		weatherRepository.createWeatherSampleTable();
	}
}
