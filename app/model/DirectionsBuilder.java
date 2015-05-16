package com.chess.app;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Constructor;

public class DirectionsBuilder {
    private List<Direction> directions;
    private Colour colour;

    public DirectionsBuilder(Colour colour) {
        this.directions = new ArrayList();
        this.colour = colour;
    }
    
    public DirectionsBuilder(List<Direction> directions, Colour colour) {
        this.directions = directions;
        this.colour = colour;
    }

    public DirectionsBuilder without(Class<?> clazz) {
        for (Direction direction : directions) {
            if (clazz.isInstance(direction)) {
                directions.remove(direction);
                break;
            }
        } 
        return this;
    }

    public DirectionsBuilder with(Direction direction) {
        direction.setReflectionByColour(colour);
        directions.add(direction); 
        return this; 
    }
    
    public List<Direction> build() {
        return directions;  
    }
   
} 
