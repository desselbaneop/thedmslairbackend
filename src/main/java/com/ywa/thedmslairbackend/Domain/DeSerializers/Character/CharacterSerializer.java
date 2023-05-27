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
        gen.writeStringField("name", character.getName());
        gen.writeStringField("description", character.getDescription());
        gen.writeStringField("backstory", character.getBackstory());
        gen.writeStringField("imgURL", character.getImgURL());
        // Serialize other properties as needed

        gen.writeEndObject();
    }
}
