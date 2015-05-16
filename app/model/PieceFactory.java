package com.chess.app;

public class PieceFactory {
    public static Piece build(String type, Colour colour, Location location) {
        if (type.equals("Pawn"))   {
            return new Pawn(colour, location); 
        } else if (type.equals("Knight")) {
            return new Knight(colour, location); 
        } else if (type.equals("Bishop")) {
            return new Bishop(colour, location); 
        } else if (type.equals("Rook")) {
            return new Rook(colour, location); 
        } else if (type.equals("Queen")) {
            return new Queen(colour, location); 
        } else {
            return new King(colour, location); 
        }
    }
}
