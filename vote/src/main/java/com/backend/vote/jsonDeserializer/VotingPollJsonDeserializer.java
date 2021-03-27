package com.backend.vote.jsonDeserializer;

import com.backend.vote.voting.VotingPoll;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class VotingPollJsonDeserializer extends JsonDeserializer<VotingPoll> {
    @Override
    public VotingPoll deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException,
            JsonProcessingException {
        if (jsonParser == null) return null;

        VotingPoll votingPoll = new VotingPoll();
        votingPoll.setId(Long.valueOf(jsonParser.getText()));
        return votingPoll;
    }
}