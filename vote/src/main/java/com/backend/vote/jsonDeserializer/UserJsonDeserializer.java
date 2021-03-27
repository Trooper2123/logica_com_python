package com.backend.vote.jsonDeserializer;

import com.backend.vote.user.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class UserJsonDeserializer extends JsonDeserializer<User> {
    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser == null) return null;

        User user = new User();
        user.setId(Long.valueOf(jsonParser.getText()));
        return user;
    }
}
