package com.chess.app;

public class UpperFile extends DirectionImpl {
    public UpperFile(int maxMoves) {
        super(maxMoves);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(location.x, upper(location.y, 1));
    }
}
