package com.chess.app;
import java.util.List;

public class Rook extends PieceImpl {
    public Rook(Colour colour, Location location) {
        super(colour, location); 
        directions = new DirectionsBuilder(colour)
            .with(new UpperFile(Integer.MAX_VALUE))
            .with(new LowerFile(Integer.MAX_VALUE))
            .with(new RightRank(Integer.MAX_VALUE))
            .with(new LeftRank(Integer.MAX_VALUE))
            .build();
    }
}
