package com.chess.app;

public class CastleLeft extends DirectionImpl {
    public CastleLeft() {
        super(1);
    }

    @Override
    public Location getNext(Location location) {
        return new Location(left(location.x, 2), location.y);
    }

    @Override
    public boolean isForPassing(Location dest) {
        Location leftRookLocation = new Location(left(dest.x, 2), dest.y);
        Location kingLocation = new Location(right(dest.x, 2), dest.y);
        Piece leftRook = board.get(leftRookLocation);
        Piece king = board.get(kingLocation);
        Location leftEnd = new Location(left(dest.x, 1), dest.y);
        Location rightEnd = new Location(right(dest.x, 1), dest.y);
        return (leftRook instanceof Rook &&
                board.isOpenRankBetween(leftEnd, rightEnd) && 
                leftRook.hasNotMoved() && king.hasNotMoved());
    }
                //board.isNotTargetedBetween(colour, dest, kingLocation));
}
