package com.borabora.example.api;

import com.borabora.example.model.WeatherInfo;
import com.borabora.example.model.WeatherSample;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("weather")
public interface WeatherApi {

    @GetMapping(path = "" , produces = "application/json")
    List<WeatherInfo> getSamples(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @PostMapping(path = "/add", consumes = "application/json")
    boolean addSample(@RequestBody WeatherSample weatherSample);
}
