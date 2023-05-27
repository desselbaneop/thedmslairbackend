package com.ywa.thedmslairbackend.Domain.DeSerializers.User;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.ywa.thedmslairbackend.Domain.User;

import java.io.IOException;

public class UserDeserializer extends JsonDeserializer<User> {

    @Override
    public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);

        // Extract the properties from the JSON node
        String name = node.get("name").asText();
        String email = node.get("email").asText();
        String password = node.get("password").asText();

        // Create a new User instance using the extracted values
        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setPassword(password);

        // Set other player properties as needed

        return user;
    }
}
