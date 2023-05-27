package com.ywa.thedmslairbackend.Domain.DeSerializers.Campaign;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ywa.thedmslairbackend.Domain.Campaign;

import java.io.IOException;

public class CampaignSerializer extends JsonSerializer<Campaign> {
    @Override
    public void serialize(Campaign campaign, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // Implement your serialization logic here
        // You can access the relevant properties of the campaign and generate the JSON structure accordingly
        gen.writeStartObject();
        gen.writeObjectField("id", campaign.getId());
        gen.writeStringField("name", campaign.getName());
        // Serialize other campaign properties as needed
        gen.writeEndObject();
    }
}
