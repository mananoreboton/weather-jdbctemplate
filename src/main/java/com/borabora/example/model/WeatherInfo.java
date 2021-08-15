package com.borabora.example.model;

import java.time.*;

public class WeatherInfo {

    private LocalTime time;
    private LocalDate date;
    private Float temperature;
    private Float light;

    public WeatherInfo(LocalDate date, LocalTime time, Float temperature, Float light) {
        this.time = time;
        this.date = date;
        this.temperature = temperature;
        this.light = light;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getLight() {
        return light;
    }

}
