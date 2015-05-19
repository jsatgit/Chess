package com.chess.app;

import java.util.List;
import java.util.ArrayList;

public abstract class Player {
    private Board board;
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

    private Piece getPiece(Class<?> pieceType) {
        for (Piece piece : pieces) {
            if (piece.isKing()) {
                return piece; 
            }   
        }
        return null;
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
        this.targetComputer.setOpponent(otherPlayer);
    }

    public void onAllPiecesAdded() {
        targetComputer.setKing(getPiece(King.class)); 
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
        Piece piece = board.get(src);          
        piece.moveTo(dest);
    }

    public void onTurnStarted() {
        targetComputer.refresh();     
    }

    private Moves getMovesForNonKing(Piece piece) {
        if (targetComputer.isUnderCheck()) {
            return new Moves();  
        } else {
            return piece.getMoves();
        }
    }
    
    private void filterTargetedMoves(List<Location> moves) {
        for (Location location : moves) {
            if (targetComputer.isTargeted(location)) {
                moves.remove(location);
            }
        } 
    }    

    private Moves filterKingMoves(Piece king) {
        Moves moves = king.getMoves();
        filterTargetedMoves(moves.getPassing());
        filterTargetedMoves(moves.getCapturing());
        return moves;
    }

    public Moves getMovesForPiece(Piece piece) {
        if (piece.isKing()) {
            return filterKingMoves(piece); 
        } else {
            return getMovesForNonKing(piece); 
        }
    }
}
