package com.borabora.example.api.payload.weather;

import java.util.UUID;

public class DeviceWeatherSample {
    private final UUID device;
    private final SampleLocation sampleLocation;
    private final Float temperature;
    private final Float light;

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
