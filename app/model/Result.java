package com.chess.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Result {
    public JsonNode toJson(ObjectMapper mapper) {
        ObjectNode json = mapper.createObjectNode();
        json.put("message", "default");
        return json;
    }
    
    protected ObjectNode locationToJson(ObjectMapper mapper, Location location) {
        ObjectNode node = mapper.createObjectNode();
        node.put("x", location.x);
        node.put("y", location.y);
        return node;
    }
}
