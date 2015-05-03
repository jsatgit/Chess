package com.chess.app;
import java.util.List;

public class Rook extends PieceImpl {
    public Rook(Player owner, Board board) {
        super(owner, board); 
        directions = new DirectionsBuilder(owner.getColour(), board)
            .with(new UpperFile(Integer.MAX_VALUE))
            .with(new LowerFile(Integer.MAX_VALUE))
            .with(new RightRank(Integer.MAX_VALUE))
            .with(new LeftRank(Integer.MAX_VALUE))
            .build();
    }
}
