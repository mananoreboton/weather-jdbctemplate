package com.borabora.example.api;

import com.borabora.example.api.payload.weather.WeatherInfo;
import com.borabora.example.api.payload.weather.DeviceWeatherSample;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("weather")
public interface WeatherApi {

    @GetMapping(path = "" , produces = "application/json")
    List<WeatherInfo> getWeatherInfo(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @PostMapping(path = "/add", consumes = "application/json")
    boolean addSample(@RequestBody DeviceWeatherSample deviceWeatherSample);
}
