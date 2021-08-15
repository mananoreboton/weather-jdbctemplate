package com.borabora.example.api;

import com.borabora.example.model.WeatherInfo;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface WeatherApi {
    @PostMapping
    List<WeatherInfo> getSamples(LocalDate startDate, LocalDate endDate);
}
