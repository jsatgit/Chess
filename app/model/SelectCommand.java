package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;

public class SelectCommand extends Command {
    public SelectCommand(JsonNode json) {
        super("select", json);
    }

    public Location getLocation() {
        return getLocation(json);
    }
}
