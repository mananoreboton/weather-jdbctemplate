package com.borabora.example.repository;

import com.borabora.example.repository.model.weather.PersistenceWeatherSample;
import com.borabora.example.repository.model.mapper.RowToPersistenceWeatherSampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class WeatherRepositoryJDBC implements WeatherRepository {
    private static final String DEVICE_COLUMN = "DEVICE";
    private static final String SAMPLE_TIMESTAMP_COLUMN = "SAMPLE_TIMESTAMP";
    private static final String TEMPERATURE_COLUMN = "TEMPERATURE";
    private static final String LIGHT_COLUMN = "LIGHT";
    private static final String LATITUDE_COLUMN = "LATITUDE";
    private static final String LONGITUDE_COLUMN = "LONGITUDE";
    private static final String WEATHER_SAMPLE_TABLE = "WEATHER_SAMPLE";
    private static final String SELECT_WEATHER_SAMPLE_QUERY = "SELECT " + DEVICE_COLUMN + ", " +
            SAMPLE_TIMESTAMP_COLUMN + ", " +
            TEMPERATURE_COLUMN + ", " +
            LIGHT_COLUMN + ", " +
            LATITUDE_COLUMN + ", " +
            LONGITUDE_COLUMN +
            " FROM " + WEATHER_SAMPLE_TABLE + ";";
    private static final String INSERT_WEATHER_SAMPLE_QUERY = "INSERT INTO " + WEATHER_SAMPLE_TABLE +
            " (" + DEVICE_COLUMN + ", " + SAMPLE_TIMESTAMP_COLUMN + ", " + TEMPERATURE_COLUMN + ", " + LIGHT_COLUMN +
            LATITUDE_COLUMN + ", " + LONGITUDE_COLUMN + ")" +
            "VALUES (?,?,?,?,?,?); ";
    private static final String CREATE_WEATHER_SAMPLE_TABLE_SQL_QUERY = "CREATE TABLE " + WEATHER_SAMPLE_TABLE + " (" +
            DEVICE_COLUMN + " BINARY(16),\n" +
            SAMPLE_TIMESTAMP_COLUMN + " TIMESTAMP,\n" +
            TEMPERATURE_COLUMN + " NUMERIC(8, 5),\n" +
            LIGHT_COLUMN + " NUMERIC(7,2),\n" +
            LATITUDE_COLUMN + " NUMERIC(8, 5),\n" +
            LONGITUDE_COLUMN + " NUMERIC(8, 5)\n" +
            ");";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WeatherRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PersistenceWeatherSample> getSamples(LocalDate startDate, LocalDate endDate) {
        return jdbcTemplate.query(SELECT_WEATHER_SAMPLE_QUERY, RowToPersistenceWeatherSampleMapper::mapRow);
    }

    @Override
    public void createWeatherSampleTable() {
        jdbcTemplate.execute(CREATE_WEATHER_SAMPLE_TABLE_SQL_QUERY);
    }

    @Override
    public Boolean addSample(PersistenceWeatherSample persistenceWeatherSample) {
        return jdbcTemplate.execute(INSERT_WEATHER_SAMPLE_QUERY, (PreparedStatementCallback<Boolean>) ps -> {
            ps.setBytes(1, persistenceWeatherSample.getDevice());
            ps.setTimestamp(2, persistenceWeatherSample.getTimestamp());
            ps.setFloat(3, persistenceWeatherSample.getTemperature());
            ps.setFloat(4, persistenceWeatherSample.getLight());
            ps.setFloat(5, persistenceWeatherSample.getLatitude());
            ps.setFloat(6, persistenceWeatherSample.getLongitude());
            return ps.execute();
        });
    }
}
