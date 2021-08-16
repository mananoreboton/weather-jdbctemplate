package com.borabora.example.model;

public class WeatherSample {
    private Long sampleTimestamp;
    private Float temperature;
    private Float light;

    public WeatherSample() {
    }

    public WeatherSample(Long sampleTimestamp, Float temperature, Float light) {
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
}
