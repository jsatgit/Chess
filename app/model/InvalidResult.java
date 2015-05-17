package com.chess.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class InvalidResult extends Result {

    @Override
    public JsonNode toJson(ObjectMapper mapper) {
        ObjectNode json = mapper.createObjectNode();
        json.put("error", "invalid");
        return json; 
    } 
}
