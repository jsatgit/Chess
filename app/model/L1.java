package com.chess.app;

public class L1 extends DirectionImpl {
    public L1() {
        super(1);
    } 

    @Override
    public Location getNext(Location location) {
        return new Location(right(location.x, 2), upper(location.y, 1));
    }
}
