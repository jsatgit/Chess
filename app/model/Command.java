package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;

public class Command {
    private String name;
    protected JsonNode json;

    public Command(String name) {
        this.name = name;
    }
    
    public Command(String name, JsonNode json) {
        this.name = name;
        this.json = json;
    }

    public boolean is(String commandName) {
        return name.equals(commandName); 
    }

    protected Location getLocation(JsonNode json) {
        int x = Integer.parseInt(json.get("x").textValue());
        int y = Integer.parseInt(json.get("y").textValue());
        return new Location(x, y);
    }
}
