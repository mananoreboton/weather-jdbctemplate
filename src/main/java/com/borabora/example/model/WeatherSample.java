package com.borabora.example.model;

import java.util.UUID;

public class WeatherSample {
    private UUID device;
    private Long sampleTimestamp;
    private Float temperature;
    private Float light;

    public WeatherSample() {
    }

    public WeatherSample(UUID device, Long sampleTimestamp, Float temperature, Float light) {
        this.device = device;
        this.sampleTimestamp = sampleTimestamp;
        this.temperature = temperature;
        this.light = light;
    }

    public Long getSampleTimestamp() {
        return sampleTimestamp;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getLight() {
        return light;
    }

    public UUID getDevice() {
        return device;
    }
}
