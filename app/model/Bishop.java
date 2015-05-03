package com.chess.app;
import java.util.List;

public class Bishop extends PieceImpl {
    public Bishop(Player owner, Board board) {
        super(owner, board); 
        directions = new DirectionsBuilder(owner.getColour(), board)
            .with(new UpperRightDiagonal(Integer.MAX_VALUE))
            .with(new UpperLeftDiagonal(Integer.MAX_VALUE))
            .with(new LowerRightDiagonal(Integer.MAX_VALUE))
            .with(new LowerLeftDiagonal(Integer.MAX_VALUE))
            .build();
    }
}
