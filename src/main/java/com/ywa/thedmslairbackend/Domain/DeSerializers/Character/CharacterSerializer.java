package com.ywa.thedmslairbackend.Domain.DeSerializers.Character;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ywa.thedmslairbackend.Domain.Character;

import java.io.IOException;

public class CharacterSerializer extends JsonSerializer<Character> {

    @Override
    public void serialize(Character character, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("id", character.getId());
        gen.writeObjectField("player", character.getPlayer());
        gen.writeObjectField("inventory", character.getInventory());
        // Serialize other character properties as needed
        gen.writeEndObject();
    }
}
