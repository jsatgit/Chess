package com.chess.app;

public class RightRank extends DirectionImpl {
    public RightRank(int maxMoves) {
        super(maxMoves);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 1), location.y);
    }
}
