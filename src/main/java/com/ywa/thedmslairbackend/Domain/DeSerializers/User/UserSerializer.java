package com.ywa.thedmslairbackend.Domain.DeSerializers.User;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ywa.thedmslairbackend.Domain.User;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        // Write the properties of the Player object
        gen.writeStringField("name", user.getUsername());
        gen.writeStringField("email", user.getEmail());
        gen.writeStringField("password", user.getPassword());

        // Write other player properties as needed

        gen.writeEndObject();
    }
}
