package com.borabora.example.repository;

import com.borabora.example.repository.model.weather.PersistenceWeatherSample;

import java.util.List;

public interface WeatherRepository {
    List<PersistenceWeatherSample> getSamples(
            Long startDateTime,
            Long endDateTime,
            float latitude,
            float longitude
    );

    void createWeatherSampleTable();

    Boolean addSample(PersistenceWeatherSample deviceWeatherSample);

    List<PersistenceWeatherSample> getSamples();
}
