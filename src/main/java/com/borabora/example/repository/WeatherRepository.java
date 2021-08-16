package com.borabora.example.repository;

import com.borabora.example.model.WeatherSample;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository {
    List<WeatherSample> getSamples(LocalDate startDate, LocalDate endDate);

    void createWeatherSampleTable();
}
