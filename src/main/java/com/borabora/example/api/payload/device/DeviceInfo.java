package com.borabora.example.api.payload.device;

import java.util.UUID;

public class DeviceInfo {
    private final UUID id;

    public DeviceInfo() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
