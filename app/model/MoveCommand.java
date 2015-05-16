package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;

public class MoveCommand extends Command {
    public MoveCommand(JsonNode json) {
        super("move", json);
    }

    public Location getSrc() {
        return getLocation(json.get("src"));      
    }

    public Location getDest() {
        return getLocation(json.get("dest"));      
    }
}
