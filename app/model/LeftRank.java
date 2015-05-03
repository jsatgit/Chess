package com.chess.app;

public class LeftRank extends DirectionImpl {
    public LeftRank(int maxMoves) {
        super(maxMoves);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 1), location.y);
    }
}
