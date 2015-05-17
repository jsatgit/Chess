package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MoveResult extends Result {
    private String resultStatus;
    private Location src;
    private Location dest;

    public MoveResult(Location src, Location dest) {
        this.src = src;
        this.dest = dest;
    }

    public MoveResult success() {
        this.resultStatus = "success";
        return this; 
    }

    @Override
    public JsonNode toJson(ObjectMapper mapper) {
        
        ObjectNode moveNode = mapper.createObjectNode();
        moveNode.put("result", resultStatus);
        moveNode.put("src", locationToJson(mapper, src));
        moveNode.put("dest", locationToJson(mapper, dest));

        ObjectNode json = mapper.createObjectNode();
        json.put("move", moveNode);
        return json;
    }
}
