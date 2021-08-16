package com.borabora.example.repository;

import com.borabora.example.model.WeatherSample;
import com.borabora.example.model.mapper.RowToWeatherSampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class WeatherRepositoryJDBC implements WeatherRepository {
    private static final String SAMPLE_TIMESTAMP_COLUMN = "SAMPLE_TIMESTAMP";
    private static final String TEMPERATURE_COLUMN =   "TEMPERATURE";
    private static final String LIGHT_COLUMN ="LIGHT";
    private static final String WEATHER_SAMPLE_TABLE = "WEATHER_SAMPLE";
    private static final String SELECT_WEATHER_SAMPLE_QUERY = "SELECT " + SAMPLE_TIMESTAMP_COLUMN + ", " +
            TEMPERATURE_COLUMN + ", " +
            LIGHT_COLUMN + ", " +
            "FROM " + WEATHER_SAMPLE_TABLE + ";";
    private static final String CREATE_WEATHER_SAMPLE_TABLE_SQL_QUERY = "CREATE TABLE " + WEATHER_SAMPLE_TABLE + " " +
            SAMPLE_TIMESTAMP_COLUMN + " TIMESTAMP WITH TIME ZONE,\n" +
            TEMPERATURE_COLUMN + " NUMERIC(8, 5),\n" +
            LIGHT_COLUMN + " NUMERIC(7,2)\n" +
            ");";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WeatherRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WeatherSample> getSamples(LocalDate startDate, LocalDate endDate) {
        return jdbcTemplate.query( SELECT_WEATHER_SAMPLE_QUERY, RowToWeatherSampleMapper::mapRow);
    }

    @Override
    public void createWeatherSampleTable() {
        jdbcTemplate.execute(CREATE_WEATHER_SAMPLE_TABLE_SQL_QUERY);
    }
}
