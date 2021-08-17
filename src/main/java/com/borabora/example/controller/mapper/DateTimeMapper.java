package com.borabora.example.controller.mapper;

import com.borabora.example.api.payload.weather.SampleLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.dustinj.timezonemap.TimeZoneMap;

import java.sql.Timestamp;
import java.time.*;
import java.util.Optional;

@Component
public class DateTimeMapper {

    private final TimeZoneMap timeZoneMap;

    @Autowired
    public DateTimeMapper(TimeZoneMap timeZoneMap) {
        this.timeZoneMap = timeZoneMap;
    }

    public LocalTime toTime(Timestamp timestamp, SampleLocation sampleLocation) {
        return calculateZonedDateTime(sampleLocation, timestamp).toLocalTime();
    }

    public LocalDate toDate(Timestamp timestamp, SampleLocation sampleLocation) {
        return calculateZonedDateTime(sampleLocation, timestamp).toLocalDate();
    }

    private ZonedDateTime calculateZonedDateTime(SampleLocation sampleLocation, Timestamp timestamp) {
        return Optional.ofNullable(timeZoneMap.getOverlappingTimeZone(sampleLocation.getLatitude(), sampleLocation.getLongitude()))
                .map(us.dustinj.timezonemap.TimeZone::getZoneId)
                .map(java.util.TimeZone::getTimeZone)
                .map(java.util.TimeZone::toZoneId)
                .map(timestamp.toInstant()::atZone)
                .orElse(timestamp.toLocalDateTime().atZone(ZoneId.systemDefault()));
    }
}
