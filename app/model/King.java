package com.chess.app;
import java.util.List;

public class King extends PieceImpl {
    public King(Player owner, Board board) {
        super(owner, board); 
        directions = new DirectionsBuilder(owner.getColour(), board)
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
