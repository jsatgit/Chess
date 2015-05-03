package com.chess.app;

public class L0 extends DirectionImpl {
    public L0() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 1), upper(location.y, 2));
    }
}
