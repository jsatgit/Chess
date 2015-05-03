package com.chess.app;
import java.util.List;

public class Knight extends PieceImpl {
    public Knight(Player owner, Board board) {
        super(owner, board); 
        directions = new DirectionsBuilder(owner.getColour(), board)
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
