package com.borabora.example.model.mapper;

import com.borabora.example.model.WeatherSample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowToWeatherSampleMapper {
    public static WeatherSample mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WeatherSample(
                new BytesToUuidMapper().map(rs.getBytes(1)),
                rs.getTimestamp(2).getTime(),
                rs.getFloat(3),
                rs.getFloat(4)
        );
    }
}
