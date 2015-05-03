package com.chess.app;
import java.util.List;
import static java.lang.Math.abs;

public class Pawn extends PieceImpl {
    private boolean justMovedTwoSquares;

    public Pawn(Player owner, Board board) {
        super(owner, board); 
        directions = new DirectionsBuilder(owner.getColour(), board)
            .with(new UpperRightDiagonal(1).forCapturingOnly())
            .with(new UpperLeftDiagonal(1).forCapturingOnly())
            .with(new UpperFile(2).forPassingOnly())
            .with(new EnPassantLeft().forCapturingOnly())
            .with(new EnPassantRight().forCapturingOnly())
            .build();
        this.justMovedTwoSquares = false;
    }
    
    private boolean movedTwoSquares(Location src, Location dest) {
        return abs(src.y - dest.y) == 2;
    }
    
    @Override
    public void beforeMove(Location src, Location dest) {
        if (movedTwoSquares(src, dest)) {
            justMovedTwoSquares = true;
            directions = new DirectionsBuilder(directions, colour, board)
                .without(UpperFile.class)
                .with(new UpperFile(1).forPassingOnly())
                .build();
        } else {
            justMovedTwoSquares = false; 
        }
    }

    public boolean hasJustMovedTwoSquares() {
        return justMovedTwoSquares; 
    }
}
