package com.chess.app;

public class L3 extends DirectionImpl {
    public L3() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 1), lower(location.y, 2));
    }
}
