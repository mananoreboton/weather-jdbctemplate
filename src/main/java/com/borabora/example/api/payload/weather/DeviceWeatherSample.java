package com.borabora.example.api.payload.weather;

import java.util.UUID;

public class DeviceWeatherSample {
    private UUID device;
    private SampleLocation sampleLocation;
    private Float temperature;
    private Float light;

    public DeviceWeatherSample() {
    }

    public DeviceWeatherSample(UUID device, SampleLocation sampleLocation, Float temperature, Float light) {
        this.device = device;
        this.sampleLocation = sampleLocation;
        this.temperature = temperature;
        this.light = light;
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

    public SampleLocation getSampleLocation() {
        return sampleLocation;
    }
}
