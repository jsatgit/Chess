package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;

public class UnknownCommand extends Command {
    public UnknownCommand() {
        super("unknown");
    }
}
