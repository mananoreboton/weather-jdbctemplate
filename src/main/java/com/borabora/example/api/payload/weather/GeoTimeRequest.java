package com.borabora.example.api.payload.weather;

import java.time.LocalDateTime;

public class GeoTimeRequest {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private SampleLocation sampleLocation;

    public GeoTimeRequest() {
    }

    public GeoTimeRequest(LocalDateTime startDateTime, LocalDateTime endDateTime, SampleLocation sampleLocation) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.sampleLocation = sampleLocation;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public SampleLocation getSampleLocation() {
        return sampleLocation;
    }
}
