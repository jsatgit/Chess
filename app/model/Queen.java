package com.chess.app;
import java.util.List;

public class Queen extends PieceImpl {
    public Queen(Colour colour, Location location) {
        super(colour, location); 
        directions = new DirectionsBuilder(colour)
            .with(new UpperRightDiagonal(Integer.MAX_VALUE))
            .with(new UpperLeftDiagonal(Integer.MAX_VALUE))
            .with(new LowerRightDiagonal(Integer.MAX_VALUE))
            .with(new LowerLeftDiagonal(Integer.MAX_VALUE))
            .with(new UpperFile(Integer.MAX_VALUE))
            .with(new LowerFile(Integer.MAX_VALUE))
            .with(new RightRank(Integer.MAX_VALUE))
            .with(new LeftRank(Integer.MAX_VALUE))
            .build();
    }
}
