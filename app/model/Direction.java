package com.chess.app;

public interface Direction {
    Location getNext(Location location);
    
    void setReflectionByColour(Colour colour); 

    boolean isWithinMoveLimit(int numMoves);

    boolean isForPassing(Location location, Board board); 
    
    boolean isForCapturing(Location location, Board board); 
    
    boolean isForPassing(); 
    
    boolean isForCapturing(); 

    Direction withColour(Colour colour);
}
