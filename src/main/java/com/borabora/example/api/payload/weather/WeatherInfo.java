package com.borabora.example.api.payload.weather;

import java.time.*;

public class WeatherInfo {

    private final LocalTime time;
    private final LocalDate date;
    private final Float temperature;
    private final Float light;
    private final SampleLocation sampleLocation;

    public WeatherInfo(LocalDate date, LocalTime time, Float temperature, Float light, SampleLocation sampleLocation) {
        this.time = time;
        this.date = date;
        this.temperature = temperature;
        this.light = light;
        this.sampleLocation = sampleLocation;
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

    public SampleLocation getSampleLocation() {
        return sampleLocation;
    }
}
