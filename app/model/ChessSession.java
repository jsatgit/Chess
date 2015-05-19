package com.chess.app;

import static play.mvc.WebSocket.Out;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChessSession {
    private Commander commander;
    private ObjectMapper mapper;

    private Player whitePlayer;
    private Player blackPlayer;
    private Game game;

    public ChessSession(Out<String> out) {
        this.commander = new Commander();
        this.mapper = new ObjectMapper();
    }
    
    private Result setupWith(SetupCommand command) {
        if (game == null) {
            this.whitePlayer = command.getWhitePlayer(); 
            this.blackPlayer = command.getBlackPlayer(); 
            this.game = new Game()
                .withWhitePlayer(whitePlayer)
                .withBlackPlayer(blackPlayer)
                .withPieces(command.getPieces())
                .start();
            return new SetupResult().success();
        } else {
            return new InvalidResult(); 
        }
    }

    private Result selectWith(SelectCommand command) {
        if (game != null) {
            Location location = command.getLocation();
            Piece piece = game.pieceAt(location);
            Player selectedPlayer = piece.getOwner();
            // TODO move this somewhere else
            if (game.isMyTurn(selectedPlayer)) {
                Moves moves = selectedPlayer.getMovesForPiece(piece);
                return new SelectResult(location, moves).success();
            } else {
                return new InvalidResult(); 
            }
        } else {
            return new InvalidResult(); 
        }
    }

    private Result moveWith(MoveCommand command) {
        if (game != null) {
            Location src = command.getSrc();
            Location dest = command.getDest();
            game.move(src, dest);
            return new MoveResult(src, dest).success();
        } else {
            return new InvalidResult(); 
        }
    }

    public JsonNode handle(String message) {
        System.out.println(message);
        Command command = commander.parse(message); 
        // TODO remove typecast
        Result result;
        if (command.is("setup")) {
            result = setupWith((SetupCommand)command); 
        } else if (command.is("select")) {
            result = selectWith((SelectCommand)command); 
        } else if (command.is("move")) {
            result = moveWith((MoveCommand)command); 
        } else {
            result = new InvalidResult(); 
        }
        return result.toJson(mapper);
    }
}
