package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;

public class SelectResult extends Result {
    private String resultStatus;
    private Moves moves; 

    public SelectResult(Moves moves) {
        this.moves = moves; 
    }

    public SelectResult success() {
        this.resultStatus = "success";
        return this; 
    }

    private ObjectNode locationToJson(ObjectMapper mapper, Location location) {
        ObjectNode node = mapper.createObjectNode();
        node.put("x", location.x);
        node.put("y", location.y);
        return node;
    }

    private ArrayNode locationsToJson(ObjectMapper mapper, List<Location> locations) {
        ArrayNode arrayNode = mapper.createArrayNode();
        for (Location location : locations) {
            arrayNode.add(locationToJson(mapper, location));
        }
        return arrayNode;
    }

    @Override
    public JsonNode toJson(ObjectMapper mapper) {
          ObjectNode movesNode = mapper.createObjectNode();
          ArrayNode capturingNode = locationsToJson(mapper, moves.getCapturing());
          ArrayNode passingNode = locationsToJson(mapper, moves.getPassing());
          movesNode.put("capturing", capturingNode);
          movesNode.put("passing", passingNode);

          ObjectNode select = mapper.createObjectNode();
          select.put("result", resultStatus);
          select.put("moves", movesNode);

          ObjectNode json = mapper.createObjectNode();
          json.put("select", select);

          return json;
    }
}
