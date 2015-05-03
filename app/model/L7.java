package com.chess.app;

public class L7 extends DirectionImpl {
    public L7() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 1), upper(location.y, 2));
    }
}

