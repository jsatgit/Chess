package com.chess.app;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Constructor;

public class DirectionsBuilder {
    private List<Direction> directions;
    private Colour colour;
    private Board board;

    public DirectionsBuilder(Colour colour, Board board) {
        this.directions = new ArrayList();
        this.colour = colour;
        this.board = board;
    }
    
    public DirectionsBuilder(List<Direction> directions, Colour colour, Board board) {
        this.directions = directions;
        this.colour = colour;
        this.board = board;
    }

    public DirectionsBuilder without(Class<?> clazz) {
        for (Direction direction : directions) {
            if (clazz.isInstance(direction)) {
                directions.remove(direction);
            }
        } 
        return this;
    }

    public DirectionsBuilder with(Direction direction) {
        direction.setReflectionByColour(colour);
        direction.setBoard(board);
        directions.add(direction); 
        return this; 
    }
    
    public List<Direction> build() {
        return directions;  
    }
   
} 
