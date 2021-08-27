package com.borabora.example.controller.mapper;

import com.borabora.example.api.payload.weather.SampleLocation;
import com.borabora.example.util.TimeZoneMapInitializer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.dustinj.timezonemap.TimeZoneMap;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ZonedDateTimeMapperTest {
    private ZonedDateTimeMapper zonedDateTimeMapper;
    private static TimeZoneMap timeZoneMap;

    @BeforeAll
    static void init() {
        timeZoneMap = new TimeZoneMapInitializer().createTimeZoneMap();
    }

    @BeforeEach
    void setUp() {
        zonedDateTimeMapper = new ZonedDateTimeMapper(timeZoneMap);
    }

    @Test
    void toTime() {
        LocalTime localTime1 = zonedDateTimeMapper.toTime(new Timestamp(1630000000L), new SampleLocation(44, 9));
        LocalTime localTime2 = zonedDateTimeMapper.toTime(new Timestamp(1630000000L), new SampleLocation(52, 25));
        assertTrue(localTime1.isBefore(localTime2));
    }

    @Test
    void toDate() {
        LocalDate localDate1 = zonedDateTimeMapper.toDate(new Timestamp(1630000000L), new SampleLocation(44, 9));
        LocalDate localDate2 = zonedDateTimeMapper.toDate(new Timestamp(1630000000L), new SampleLocation(52, 25));
        assertEquals(localDate1, localDate2);
    }
}