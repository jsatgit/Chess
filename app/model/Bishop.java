package com.chess.app;
import java.util.List;

public class Bishop extends PieceImpl {
    public Bishop(Colour colour, Location location) {
        super(colour, location); 
        directions = new DirectionsBuilder(colour)
            .with(new UpperRightDiagonal(Integer.MAX_VALUE))
            .with(new UpperLeftDiagonal(Integer.MAX_VALUE))
            .with(new LowerRightDiagonal(Integer.MAX_VALUE))
            .with(new LowerLeftDiagonal(Integer.MAX_VALUE))
            .build();
    }
}
