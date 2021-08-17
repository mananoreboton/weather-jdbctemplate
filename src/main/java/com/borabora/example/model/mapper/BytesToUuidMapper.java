package com.borabora.example.model.mapper;

import java.nio.ByteBuffer;
import java.util.UUID;

public class BytesToUuidMapper {
    public UUID map(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();
        return new UUID(high, low);
    }
}
