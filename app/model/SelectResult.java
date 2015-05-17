package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;

public class SelectResult extends Result {
    private Location source;
    private String resultStatus;
    private Moves moves; 

    public SelectResult(Location location, Moves moves) {
        this.source = location;
        this.moves = moves; 
    }

    public SelectResult success() {
        this.resultStatus = "success";
        return this; 
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
        select.put("source", locationToJson(mapper, source));
        select.put("moves", movesNode);

        ObjectNode json = mapper.createObjectNode();
        json.put("select", select);

        return json;
    }
}
