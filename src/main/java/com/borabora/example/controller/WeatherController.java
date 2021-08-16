package com.borabora.example.controller;

import com.borabora.example.api.WeatherApi;
import com.borabora.example.model.WeatherInfo;
import com.borabora.example.model.WeatherSample;
import com.borabora.example.model.mapper.WeatherSampleToWeatherInfoMapper;
import com.borabora.example.repository.WeatherRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("weather")
public class WeatherController implements WeatherApi {

    private final WeatherRepository weatherRepository;
    private final WeatherSampleToWeatherInfoMapper weatherSampleToWeatherInfoMapper;

    public WeatherController(WeatherRepository weatherRepository, WeatherSampleToWeatherInfoMapper weatherSampleToWeatherInfoMapper) {
        this.weatherRepository = weatherRepository;
        this.weatherSampleToWeatherInfoMapper = weatherSampleToWeatherInfoMapper;
    }


    @GetMapping(path = "" , produces = "application/json")
    @Override
    public List<WeatherInfo> getSamples(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate endDate) {
        return weatherRepository.getSamples(startDate, endDate).stream()
                .map(weatherSampleToWeatherInfoMapper::map)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @Override
    public boolean addSample(@RequestBody WeatherSample weatherSample) {
        return false;
    }
}
