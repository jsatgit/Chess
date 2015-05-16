package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.WebSocket.Out;
import java.io.IOException;

public class Commander {
    private ObjectMapper mapper;

    public Commander() {
        this.mapper = new ObjectMapper();
    }

    public Command parse(String message) {
        Command command;
        try {
            JsonNode json = mapper.readTree(message);
            if (json.has("setup")) {
                command = new SetupCommand(json.get("setup"));
            } else if (json.has("select")) {
                command = new SelectCommand(json.get("select"));
            } else if (json.has("move")) {
                command = new MoveCommand(json.get("move"));
            } else {
                command = new UnknownCommand();
            }
        } catch (IOException e) {
            System.out.println("Failed to parse string to json.");
            command = new UnknownCommand();
        }
        return command;
    }
}
