package com.chess.app;

public class UpperRightDiagonal extends DirectionImpl {
    public UpperRightDiagonal(int maxMoves) {
        super(maxMoves);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 1), upper(location.y, 1));
    }
}
