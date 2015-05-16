package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SetupResult extends Result {
    private String resultStatus;

    public SetupResult success() {
        this.resultStatus = "success";
        return this; 
    }

    @Override
    public JsonNode toJson(ObjectMapper mapper) {
          ObjectNode setup = mapper.createObjectNode();
          setup.put("result", resultStatus);

          ObjectNode json = mapper.createObjectNode();
          json.put("setup", setup);

          return json;
    }
}
