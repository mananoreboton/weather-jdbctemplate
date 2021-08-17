package com.borabora.example.repository;

import com.borabora.example.repository.model.weather.PersistenceWeatherSample;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository {
    List<PersistenceWeatherSample> getSamples(LocalDate startDate, LocalDate endDate);

    void createWeatherSampleTable();

    Boolean addSample(PersistenceWeatherSample deviceWeatherSample);
}
