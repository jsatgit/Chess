package com.chess.app;

public class L5 extends DirectionImpl {
    public L5() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 2), lower(location.y, 1));
    }
}
