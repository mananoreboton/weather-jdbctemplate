package com.borabora.example;

import com.borabora.example.repository.WeatherRepository;
import com.borabora.example.repository.WeatherRepositoryJDBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import us.dustinj.timezonemap.TimeZoneMap;

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
		logger.info("Executing SQL");
		weatherRepository.createWeatherSampleTable();
	}

	@Bean
	public TimeZoneMap createTimeZoneMap() {
		logger.info("Creating Time Zone Map");
		return TimeZoneMap.forRegion(43.5, 8.0, 53.00, 26.0);
	}
}
