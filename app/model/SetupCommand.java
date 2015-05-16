package com.chess.app;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class SetupCommand extends Command {
    public SetupCommand(JsonNode json) {
        super("setup", json);
    }

    private Player getPlayerByColour(String colour) {
        JsonNode players = json.get("players");
        String playerType = players.get(colour).textValue();
        return PlayerFactory.build(playerType); 
    }

    public Player getWhitePlayer() {
        return getPlayerByColour("white");
    }

    public Player getBlackPlayer() {
        return getPlayerByColour("black");
    }

    public List<Piece> getPieces() {
        List<Piece> pieces = new ArrayList();
        Iterator<JsonNode> jsonPieces = json.get("pieces").elements();
        while(jsonPieces.hasNext()) {
            JsonNode jsonPiece = jsonPieces.next();
            String type = jsonPiece.get("type").textValue(); 
            String colour = jsonPiece.get("colour").textValue();
            Location location = getLocation(jsonPiece.get("location"));
            Piece piece = PieceFactory.build(type, Colour.valueOf(colour), location);
            pieces.add(piece);
        }
        return pieces;
    }
}
