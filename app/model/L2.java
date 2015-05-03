package com.chess.app;

public class L2 extends DirectionImpl {
    public L2() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 2), lower(location.y, 1));
    }
}
