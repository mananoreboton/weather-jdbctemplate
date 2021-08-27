package com.borabora.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import us.dustinj.timezonemap.TimeZoneMap;

@Component
public class TimeZoneMapInitializer {
    Logger logger = LoggerFactory.getLogger(TimeZoneMapInitializer.class);

    @Bean
    public TimeZoneMap createTimeZoneMap() {
        logger.info("Creating Time Zone Map");
        return TimeZoneMap.forRegion(43.5, 8.0, 53.00, 26.0);
    }
}
