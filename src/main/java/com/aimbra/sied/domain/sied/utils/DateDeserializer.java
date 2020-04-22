package com.aimbra.sied.domain.sied.utils;

import com.aimbra.sied.domain.sied.exceptions.BadRequestException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Service
public class DateDeserializer {
    public GsonBuilder deserialize() {
        return new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                try {
                    return DateConverter.toLocalDateTime(jsonElement.getAsString());
                } catch (Exception e) {
                    throw new BadRequestException("Erro ao converter a data");
                }
            }
        });
    }
}
