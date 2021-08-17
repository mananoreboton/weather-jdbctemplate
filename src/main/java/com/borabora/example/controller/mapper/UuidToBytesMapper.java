package com.borabora.example.controller.mapper;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UuidToBytesMapper {
    public byte[] map(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }
}
