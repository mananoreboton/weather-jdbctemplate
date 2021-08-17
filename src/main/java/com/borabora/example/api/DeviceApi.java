package com.borabora.example.api;

import com.borabora.example.api.payload.device.DeviceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("device")
public interface DeviceApi {

    @GetMapping(path = "", produces = "application/json")
    List<DeviceInfo> getDevices();

    @GetMapping(path = "/add", consumes = "application/json")
    boolean registerDevice();
}
