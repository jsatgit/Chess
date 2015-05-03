package com.chess.app;

public interface Direction {
    Location getNext(Location location);
    
    void setReflectionByColour(Colour colour); 
    
    void setBoard(Board board);

    boolean isWithinMoveLimit(int numMoves);

    boolean isForPassing(Location location); 
    
    boolean isForCapturing(Location location); 
    
    boolean isForPassing(); 
    
    boolean isForCapturing(); 

    Direction withColour(Colour colour);
}
