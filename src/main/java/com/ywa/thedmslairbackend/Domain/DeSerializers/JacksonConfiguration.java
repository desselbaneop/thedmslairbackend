package com.ywa.thedmslairbackend.Domain.DeSerializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ywa.thedmslairbackend.Domain.Campaign;
import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.DeSerializers.Campaign.CampaignDeserializer;
import com.ywa.thedmslairbackend.Domain.DeSerializers.Campaign.CampaignSerializer;
import com.ywa.thedmslairbackend.Domain.DeSerializers.Character.CharacterDeserializer;
import com.ywa.thedmslairbackend.Domain.DeSerializers.Character.CharacterSerializer;
import com.ywa.thedmslairbackend.Domain.DeSerializers.User.UserSerializer;
import com.ywa.thedmslairbackend.Domain.User;
import com.ywa.thedmslairbackend.Domain.DeSerializers.User.UserDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        // Register the serializer for Campaign
        module.addSerializer(Campaign.class, new CampaignSerializer());

        // Register the deserializer for Campaign
        module.addDeserializer(Campaign.class, new CampaignDeserializer());

        // Register the serializer for Character
        module.addSerializer(Character.class, new CharacterSerializer());

        // Register the deserializer for Character
        module.addDeserializer(Character.class, new CharacterDeserializer());

        module.addSerializer(User.class, new UserSerializer());

        module.addDeserializer(User.class, new UserDeserializer());

        objectMapper.registerModule(module);
        return objectMapper;
    }
}
