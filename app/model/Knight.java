package com.chess.app;
import java.util.List;

public class Knight extends PieceImpl {
    public Knight(Colour colour, Location location) {
        super(colour, location); 
        directions = new DirectionsBuilder(colour)
            .with(new L0())
            .with(new L1())
            .with(new L2())
            .with(new L3())
            .with(new L4())
            .with(new L5())
            .with(new L6())
            .with(new L7())
            .build();
    }
}
