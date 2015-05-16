package com.chess.app;

import java.util.List;
import java.util.ArrayList;

public abstract class Player {
    private Board board;
    private Game game;
    private Colour colour;
    private Player otherPlayer;
    private List<Piece> pieces;
    private TargetComputer targetComputer;

    public Player() {
        this.pieces = new ArrayList();
    }

    public void setBoard(Board board) {
        this.board = board; 

        // TODO maybe separate this
        this.targetComputer = new TargetComputer(board);
    }

    public void setGame(Game game) {
        this.game = game; 
    }
    
    public List<Piece> getPieces() {
        return pieces;
    }
    
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer; 
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }

    public void move(Location src, Location dest) {
        if (game.isMyTurn(this)) {
            Piece piece = board.get(src);          
            piece.moveTo(dest);
            game.onMoveEnd();
        }
    }
}
