package com.ywa.thedmslairbackend.Domain.DeSerializers.Campaign;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.ywa.thedmslairbackend.Domain.Campaign;

import java.io.IOException;

public class CampaignDeserializer extends JsonDeserializer<Campaign> {
    @Override
    public Campaign deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String name = node.get("name").asText();
        String description = node.get("description").asText();
        // Create a new Campaign instance using the deserialized values
        // Set other campaign properties as needed
        return new Campaign(name, description);
    }
}
