package com.borabora.example.api;

import com.borabora.example.model.WeatherInfo;
import com.borabora.example.model.WeatherSample;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface WeatherApi {
    List<WeatherInfo> getSamples(LocalDate startDate, LocalDate endDate);

    boolean addSample(WeatherSample weatherSample);
}
