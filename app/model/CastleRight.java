package com.chess.app;

public class CastleRight extends DirectionImpl {
    public CastleRight() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 2), location.y);
    }

    @Override
    public boolean isForPassing(Location dest) {
        return true;
    }
}
