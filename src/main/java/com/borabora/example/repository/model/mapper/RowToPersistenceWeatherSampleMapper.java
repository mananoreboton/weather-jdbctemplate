package com.borabora.example.repository.model.mapper;

import com.borabora.example.repository.model.weather.PersistenceWeatherSample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowToPersistenceWeatherSampleMapper {
    public static PersistenceWeatherSample mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PersistenceWeatherSample(
                rs.getBytes(1),
                rs.getTimestamp(2),
                rs.getFloat(3),
                rs.getFloat(4),
                rs.getFloat(5),
                rs.getFloat(6)
        );
    }
}
