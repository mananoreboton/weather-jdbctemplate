package com.borabora.example;

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
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ServiceExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		jdbcTemplate.execute("CREATE TABLE WEATHER_SAMPLE (\n" +
				"    SAMPLE_TIMESTAMP TIMESTAMP WITH TIME ZONE,\n" +
				"    TEMPERATURE NUMERIC(8, 5),\n" +
				"    LIGHT NUMERIC(7,2)\n" +
				");");
	}
}
