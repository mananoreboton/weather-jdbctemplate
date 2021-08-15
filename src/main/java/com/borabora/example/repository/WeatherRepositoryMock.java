package com.borabora.example.repository;

import com.borabora.example.model.WeatherSample;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class WeatherRepositoryMock implements WeatherRepository{

    @Override
    public List<WeatherSample> getSamples(LocalDate startDate, LocalDate endDate) {
        return Collections.singletonList(new WeatherSample(System.currentTimeMillis(), 22.2F, 90.1F));
    }
}
