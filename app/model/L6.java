package com.chess.app;

public class L6 extends DirectionImpl {
    public L6() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 2), upper(location.y, 1));
    }
}
