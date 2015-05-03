package com.chess.app;

public class UpperLeftDiagonal extends DirectionImpl {
    public UpperLeftDiagonal(int maxMoves) {
        super(maxMoves);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 1), upper(location.y, 1));
    }
}
