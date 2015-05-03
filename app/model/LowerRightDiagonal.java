package com.chess.app;

public class LowerRightDiagonal extends DirectionImpl {
    public LowerRightDiagonal(int maxMoves) {
        super(maxMoves);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 1), lower(location.y, 1));
    }
}
