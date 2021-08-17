package com.borabora.example.controller.mapper;

import com.borabora.example.api.payload.weather.DeviceWeatherSample;
import com.borabora.example.repository.model.weather.PersistenceWeatherSample;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DeviceWeatherSampleToPersistenceSampleMapper {

    public PersistenceWeatherSample map(DeviceWeatherSample deviceWeatherSample) {
        return new PersistenceWeatherSample(
                new UuidToBytesMapper().map(deviceWeatherSample.getDevice()),
                new Timestamp(System.currentTimeMillis()),
                deviceWeatherSample.getTemperature(),
                deviceWeatherSample.getLight(),
                deviceWeatherSample.getSampleLocation().getLatitude(),
                deviceWeatherSample.getSampleLocation().getLongitude()
        );
    }
}

