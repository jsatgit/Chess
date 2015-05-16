package com.chess.app;

public class Board {
    public static final int MAX_ROWS = 8;
    public static final int MAX_COLUMNS = 8;

    private Piece[][] grid; 

    public Piece get(Location location) {
        return grid[location.y][location.x]; 
    }

    public Board() {
        grid = new Piece[MAX_ROWS][MAX_COLUMNS];
    }

    public void place(Piece piece, Location location) {
        grid[location.y][location.x] = piece;
        piece.setLocation(location);
    }

    public static boolean isValidLocation(Location location) {
        return location.x >= 0 && location.x < MAX_COLUMNS 
            && location.y >= 0 && location.y < MAX_ROWS;
    }

    public boolean isFree(Location location) {
        return grid[location.y][location.x] == null; 
    }
    
    public boolean isOccupied(Location location) {
        return !isFree(location); 
    }
    
    public boolean isOccupiedByOpponent(Colour thisColour, Location location) {
        Piece piece = grid[location.y][location.x];
        if (piece != null) {
            return piece.isOpponent(thisColour);
        } 
        return false;
    }

    public boolean isOpenRankBetween(Location start, Location end) {
        for (Location location = new Location(start); location.xLessThan(end); location.incrementX(1)) {
            if (isOccupied(location)) {
                return false;
            }
        }
        return true;
    }

    /*
    public boolean isNotTargetedBetween(Colour colour, Location start, Location end) {
        for (Location location = new Location(start); location.xLessThan(end); location.incrementX(1)) {
            if (targetComputer.isTargeted(colour, location)) {
                return false;
            }
        }
        return true;
    }
    */

    private void evacuateLocation(Location location) {
        grid[location.y][location.x] = null;
    }

    public void move(Location src, Location dest) {
        Piece piece = get(src);
        evacuateLocation(src);
        place(piece, dest); 
    }
}
