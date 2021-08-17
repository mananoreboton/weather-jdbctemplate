package com.borabora.example.repository;

import com.borabora.example.model.WeatherSample;
import com.borabora.example.model.mapper.RowToWeatherSampleMapper;
import com.borabora.example.model.mapper.UuidToBytesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Repository
public class WeatherRepositoryJDBC implements WeatherRepository {
    private static final String DEVICE_COLUMN = "DEVICE";
    private static final String SAMPLE_TIMESTAMP_COLUMN = "SAMPLE_TIMESTAMP";
    private static final String TEMPERATURE_COLUMN =   "TEMPERATURE";
    private static final String LIGHT_COLUMN ="LIGHT";
    private static final String WEATHER_SAMPLE_TABLE = "WEATHER_SAMPLE";
    private static final String SELECT_WEATHER_SAMPLE_QUERY = "SELECT " + DEVICE_COLUMN + ", " +
            SAMPLE_TIMESTAMP_COLUMN + ", " +
            TEMPERATURE_COLUMN + ", " +
            LIGHT_COLUMN +
            " FROM " + WEATHER_SAMPLE_TABLE + ";";
    private static final String INSERT_WEATHER_SAMPLE_QUERY = "INSERT INTO " + WEATHER_SAMPLE_TABLE +
            " (" + DEVICE_COLUMN + ", " + SAMPLE_TIMESTAMP_COLUMN + ", " + TEMPERATURE_COLUMN + ", " + LIGHT_COLUMN +")" +
            "VALUES (?,?,?,?); ";
    private static final String CREATE_WEATHER_SAMPLE_TABLE_SQL_QUERY = "CREATE TABLE " + WEATHER_SAMPLE_TABLE + " (" +
            DEVICE_COLUMN + " BINARY(16),\n" +
            SAMPLE_TIMESTAMP_COLUMN + " TIMESTAMP WITH TIME ZONE,\n" +
            TEMPERATURE_COLUMN + " NUMERIC(8, 5),\n" +
            LIGHT_COLUMN + " NUMERIC(7,2)\n" +
            ");";

    private final JdbcTemplate jdbcTemplate;

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

    @Override
    public Boolean addSample(WeatherSample weatherSample) {
        return jdbcTemplate.execute(INSERT_WEATHER_SAMPLE_QUERY, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setBytes(1, new UuidToBytesMapper().map(weatherSample.getDevice()));
            ps.setTimestamp(2, new Timestamp(weatherSample.getSampleTimestamp()), Calendar.getInstance());
            ps.setFloat(3, weatherSample.getTemperature());
            ps.setFloat(4, weatherSample.getLight());
            return ps.execute();
        });
    }
}
