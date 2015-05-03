package com.chess.app;

public class EnPassantRight extends DirectionImpl {
    public EnPassantRight() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 1), location.y);
    }

    @Override
    public boolean isForCapturing(Location dest) {
        Piece piece = board.get(dest);
        if (piece instanceof Pawn) { 
            Pawn pawn = (Pawn)piece;
            return pawn.hasJustMovedTwoSquares();
        } else {
            return false;
        }
    }
}
