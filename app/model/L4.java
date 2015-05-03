package com.chess.app;

public class L4 extends DirectionImpl {
    public L4() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 1), lower(location.y, 2));
    }
}
