package com.borabora.example.repository.model.weather;

import java.sql.Timestamp;

public class PersistenceWeatherSample {
    private final byte[] device;
    private final Timestamp timestamp;
    private final float temperature;
    private final float light;
    private final float latitude;
    private final float longitude;

    public PersistenceWeatherSample(byte[] device, Timestamp timestamp, float temperature, float light, float latitude, float longitude) {
        this.device = device;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.light = light;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public byte[] getDevice() {
        return device;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getLight() {
        return light;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

/*
    ps.setBytes(1, new UuidToBytesMapper().map(deviceWeatherSample.getDevice()));
            ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()), Calendar.getInstance());
            ps.setFloat(3, deviceWeatherSample.getTemperature());
            ps.setFloat(4, deviceWeatherSample.getLight());
     */
}
