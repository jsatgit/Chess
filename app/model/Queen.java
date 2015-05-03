package com.chess.app;
import java.util.List;

public class Queen extends PieceImpl {
    public Queen(Player owner, Board board) {
        super(owner, board); 
        directions = new DirectionsBuilder(owner.getColour(), board)
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
