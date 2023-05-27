package com.ywa.thedmslairbackend.Domain.DeSerializers.Character;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.Inventory;
import com.ywa.thedmslairbackend.Domain.User;

import java.io.IOException;

public class CharacterDeserializer extends JsonDeserializer<Character> {
    @Override
    public Character deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        String name = node.get("name").asText();
        String description = node.get("description").asText();
        String backstory = node.get("backstory").asText();
        String imgURL = node.get("imgURL").asText();
        User user = objectMapper.treeToValue(node.get("user"), User.class);
        Inventory inventory = objectMapper.treeToValue(node.get("inventory"), Inventory.class);
        // Create a new Character instance using the deserialized values
        Character character = new Character();
        character.setUser(user);
        character.setInventory(inventory);
        character.setName(name);
        character.setDescription(description);
        character.setBackstory(backstory);
        character.setImgURL(imgURL);
        // Set other character properties as needed
        return character;
    }
}
