package com.borabora.example.controller.mapper;

import com.borabora.example.repository.model.weather.PersistenceWeatherSample;
import com.borabora.example.api.payload.weather.SampleLocation;
import com.borabora.example.api.payload.weather.WeatherInfo;
import org.springframework.stereotype.Component;

@Component
public class PersistenceWeatherSampleToWeatherInfoMapper {

    private final DateTimeMapper dateTimeMapper;

    public PersistenceWeatherSampleToWeatherInfoMapper(DateTimeMapper dateTimeMapper) {
        this.dateTimeMapper = dateTimeMapper;
    }

    public WeatherInfo map(PersistenceWeatherSample persistenceWeatherSample) {
        SampleLocation sampleLocation = new SampleLocation(persistenceWeatherSample.getLatitude(), persistenceWeatherSample.getLongitude());
        return new WeatherInfo(
                dateTimeMapper.toDate(persistenceWeatherSample.getTimestamp(), sampleLocation),
                dateTimeMapper.toTime(persistenceWeatherSample.getTimestamp(), sampleLocation),
                persistenceWeatherSample.getTemperature(),
                persistenceWeatherSample.getLight(),
                sampleLocation
        );
    }
}
