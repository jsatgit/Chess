package com.chess.app;

public class LowerLeftDiagonal extends DirectionImpl {
    public LowerLeftDiagonal(int maxMoves) {
        super(maxMoves);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 1), lower(location.y, 1));
    }
}
