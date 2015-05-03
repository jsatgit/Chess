package com.chess.app;

public class Location {
    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location(Location other) {
        this.x = other.x;
        this.y = other.y;
    }

    public boolean xLessThan(Location other) {
        return this.x < other.x; 
    }

    public void incrementX(int n) {
        this.x += n; 
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        }     
        if (obj == this) {
            return true;
        }

        Location other = (Location)obj;
        if (this.x == other.x && this.y == other.y) {
            return true; 
        } 
        return false;
    }
}
