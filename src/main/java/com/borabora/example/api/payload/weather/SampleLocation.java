package com.borabora.example.api.payload.weather;

public class SampleLocation {

    private final float latitude;
    private final float longitude;

    public SampleLocation(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
}
