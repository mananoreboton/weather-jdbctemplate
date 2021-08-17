package com.borabora.example.model.mapper;

import com.borabora.example.model.WeatherInfo;
import com.borabora.example.model.WeatherSample;
import org.springframework.stereotype.Component;

@Component
public class WeatherSampleToWeatherInfoMapper {

    private final DateTimeMapper dateTimeMapper;

    public WeatherSampleToWeatherInfoMapper(DateTimeMapper dateTimeMapper) {
        this.dateTimeMapper = dateTimeMapper;
    }

    public WeatherInfo map(WeatherSample sample) {
        return new WeatherInfo(
                dateTimeMapper.toDate(sample.getSampleTimestamp()),
                dateTimeMapper.toTime(sample.getSampleTimestamp()),
                sample.getTemperature(),
                sample.getLight());
    }
}
