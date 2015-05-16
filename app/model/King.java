package com.chess.app;
import java.util.List;

public class King extends PieceImpl {
    public King(Colour colour, Location location) {
        super(colour, location); 
        directions = new DirectionsBuilder(colour)
            .with(new UpperRightDiagonal(1))
            .with(new UpperLeftDiagonal(1))
            .with(new LowerRightDiagonal(1))
            .with(new LowerLeftDiagonal(1))
            .with(new UpperFile(1))
            .with(new LowerFile(1))
            .with(new RightRank(1))
            .with(new LeftRank(1))
            .with(new CastleRight().forPassingOnly())
            .with(new CastleLeft().forPassingOnly())
            .build();
    }
}
