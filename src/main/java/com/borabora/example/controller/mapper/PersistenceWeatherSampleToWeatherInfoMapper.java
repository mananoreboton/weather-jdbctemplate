package com.borabora.example.controller.mapper;

import com.borabora.example.api.payload.weather.SampleLocation;
import com.borabora.example.api.payload.weather.WeatherInfo;
import com.borabora.example.repository.model.weather.PersistenceWeatherSample;
import org.springframework.stereotype.Component;

@Component
public class PersistenceWeatherSampleToWeatherInfoMapper {

    private final ZonedDateTimeMapper zonedDateTimeMapper;

    public PersistenceWeatherSampleToWeatherInfoMapper(ZonedDateTimeMapper zonedDateTimeMapper) {
        this.zonedDateTimeMapper = zonedDateTimeMapper;
    }

    public WeatherInfo map(PersistenceWeatherSample persistenceWeatherSample) {
        SampleLocation sampleLocation = new SampleLocation(persistenceWeatherSample.getLatitude(), persistenceWeatherSample.getLongitude());
        return new WeatherInfo(
                zonedDateTimeMapper.toDate(persistenceWeatherSample.getTimestamp(), sampleLocation),
                zonedDateTimeMapper.toTime(persistenceWeatherSample.getTimestamp(), sampleLocation),
                persistenceWeatherSample.getTemperature(),
                persistenceWeatherSample.getLight(),
                sampleLocation
        );
    }
}
