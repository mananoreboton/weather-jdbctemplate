package com.borabora.example.repository;

import com.borabora.example.model.WeatherSample;
import com.borabora.example.model.mapper.RowToWeatherSampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class WeatherRepositoryJDBC  implements WeatherRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WeatherRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WeatherSample> getSamples(LocalDate startDate, LocalDate endDate) {
        return jdbcTemplate.query("SELECT SAMPLE_TIMESTAMP, TEMPERATURE, LIGHT FROM WEATHER_SAMPLE", RowToWeatherSampleMapper::mapRow);
    }
}
