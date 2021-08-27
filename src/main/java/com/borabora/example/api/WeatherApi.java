package com.borabora.example.api;

import com.borabora.example.api.payload.weather.DeviceWeatherSample;
import com.borabora.example.api.payload.weather.GeoTimeRequest;
import com.borabora.example.api.payload.weather.WeatherInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("weather")
public interface WeatherApi {

    @GetMapping(path = "", produces = "application/json")
    List<WeatherInfo> getWeatherInfo();

    @PostMapping(path = "", produces = "application/json", consumes = "application/json")
    List<WeatherInfo> getWeatherInfo(@RequestBody GeoTimeRequest geoTimeRequest);

    @PostMapping(path = "/add", consumes = "application/json")
    boolean addSample(@RequestBody DeviceWeatherSample deviceWeatherSample);
}
