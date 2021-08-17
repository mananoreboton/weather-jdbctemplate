package com.borabora.example.controller;

import com.borabora.example.api.WeatherApi;
import com.borabora.example.api.payload.weather.DeviceWeatherSample;
import com.borabora.example.api.payload.weather.WeatherInfo;
import com.borabora.example.controller.mapper.DeviceWeatherSampleToPersistenceSampleMapper;
import com.borabora.example.controller.mapper.PersistenceWeatherSampleToWeatherInfoMapper;
import com.borabora.example.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController implements WeatherApi {

    private final WeatherRepository weatherRepository;
    private final PersistenceWeatherSampleToWeatherInfoMapper persistenceWeatherSampleToWeatherInfoMapper;
    private final DeviceWeatherSampleToPersistenceSampleMapper deviceWeatherSampleToPersistenceSampleMapper;

    @Autowired
    public WeatherController(
            WeatherRepository weatherRepository,
            PersistenceWeatherSampleToWeatherInfoMapper persistenceWeatherSampleToWeatherInfoMapper,
            DeviceWeatherSampleToPersistenceSampleMapper deviceWeatherSampleToPersistenceSampleMapper) {
        this.weatherRepository = weatherRepository;
        this.persistenceWeatherSampleToWeatherInfoMapper = persistenceWeatherSampleToWeatherInfoMapper;
        this.deviceWeatherSampleToPersistenceSampleMapper = deviceWeatherSampleToPersistenceSampleMapper;
    }

    @Override
    public List<WeatherInfo> getWeatherInfo(LocalDate startDate, LocalDate endDate) {
        return weatherRepository.getSamples(startDate, endDate).stream()
                .map(persistenceWeatherSampleToWeatherInfoMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public boolean addSample(DeviceWeatherSample deviceWeatherSample) {
        return weatherRepository.addSample(deviceWeatherSampleToPersistenceSampleMapper.map(deviceWeatherSample));
    }
}
