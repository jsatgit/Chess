package com.chess.app;

public class LowerFile extends DirectionImpl {
    public LowerFile(int maxMoves) {
        super(maxMoves);    
    } 

    @Override
    public Location getNext(Location location) {
        return new Location(location.x, lower(location.y, 1));
    }
}
