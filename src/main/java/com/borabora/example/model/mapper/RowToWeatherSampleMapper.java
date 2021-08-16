package com.borabora.example.model.mapper;

import com.borabora.example.model.WeatherSample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowToWeatherSampleMapper {
    public static WeatherSample mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WeatherSample(
                rs.getTimestamp(1).getTime(),
                rs.getFloat(2),
                rs.getFloat(3)
        );
    }
}
