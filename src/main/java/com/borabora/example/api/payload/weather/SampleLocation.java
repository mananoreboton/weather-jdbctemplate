package com.borabora.example.api.payload.weather;

public class SampleLocation {

    private float latitude;
    private float longitude;

    public SampleLocation() {
    }

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
