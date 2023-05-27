package com.ywa.thedmslairbackend.Domain.DeSerializers.Character;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ywa.thedmslairbackend.Domain.Character;
import com.ywa.thedmslairbackend.Domain.Inventory;
import com.ywa.thedmslairbackend.Domain.Player;

import java.io.IOException;

public class CharacterDeserializer extends JsonDeserializer<Character> {
    @Override
    public Character deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = p.getCodec().readTree(p);
        Player player = objectMapper.treeToValue(node.get("player"), Player.class);
        Inventory inventory = objectMapper.treeToValue(node.get("inventory"), Inventory.class);
        // Create a new Character instance using the deserialized values
        Character character = new Character();
        character.setPlayer(player);
        character.setInventory(inventory);
        // Set other character properties as needed
        return character;
    }
}
