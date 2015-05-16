package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MoveResult extends Result {
    private String resultStatus;

    public MoveResult success() {
        this.resultStatus = "success";
        return this; 
    }

    @Override
    public JsonNode toJson(ObjectMapper mapper) {
          ObjectNode json = mapper.createObjectNode();
          json.put("result", resultStatus);
          return json;
    }
}
