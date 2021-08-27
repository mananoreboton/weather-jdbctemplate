package com.borabora.example.controller;

import com.borabora.example.api.WeatherApi;
import com.borabora.example.api.payload.weather.DeviceWeatherSample;
import com.borabora.example.api.payload.weather.GeoTimeRequest;
import com.borabora.example.api.payload.weather.WeatherInfo;
import com.borabora.example.controller.mapper.DeviceWeatherSampleToPersistenceSampleMapper;
import com.borabora.example.controller.mapper.PersistenceWeatherSampleToWeatherInfoMapper;
import com.borabora.example.controller.mapper.ZonedDateTimeMapper;
import com.borabora.example.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController implements WeatherApi {

    private final WeatherRepository weatherRepository;
    private final PersistenceWeatherSampleToWeatherInfoMapper persistenceWeatherSampleToWeatherInfoMapper;
    private final DeviceWeatherSampleToPersistenceSampleMapper deviceWeatherSampleToPersistenceSampleMapper;
    private final ZonedDateTimeMapper zonedDateTimeMapper;

    @Autowired
    public WeatherController(
            WeatherRepository weatherRepository,
            PersistenceWeatherSampleToWeatherInfoMapper persistenceWeatherSampleToWeatherInfoMapper,
            DeviceWeatherSampleToPersistenceSampleMapper deviceWeatherSampleToPersistenceSampleMapper, ZonedDateTimeMapper zonedDateTimeMapper) {
        this.weatherRepository = weatherRepository;
        this.persistenceWeatherSampleToWeatherInfoMapper = persistenceWeatherSampleToWeatherInfoMapper;
        this.deviceWeatherSampleToPersistenceSampleMapper = deviceWeatherSampleToPersistenceSampleMapper;
        this.zonedDateTimeMapper = zonedDateTimeMapper;
    }

    @Override
    public List<WeatherInfo> getWeatherInfo() {
        return weatherRepository.getSamples().stream()
                .map(persistenceWeatherSampleToWeatherInfoMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<WeatherInfo> getWeatherInfo(GeoTimeRequest geoTimeRequest) {
        return weatherRepository.getSamples(
                        zonedDateTimeMapper.calculateEpocMillis(geoTimeRequest.getSampleLocation(), geoTimeRequest.getStartDateTime()),
                        zonedDateTimeMapper.calculateEpocMillis(geoTimeRequest.getSampleLocation(), geoTimeRequest.getEndDateTime()),
                        geoTimeRequest.getSampleLocation().getLatitude(),
                        geoTimeRequest.getSampleLocation().getLongitude()
                ).stream()
                .map(persistenceWeatherSampleToWeatherInfoMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addSample(DeviceWeatherSample deviceWeatherSample) {
        return weatherRepository.addSample(deviceWeatherSampleToPersistenceSampleMapper.map(deviceWeatherSample));
    }
}
