package com.chess.app;

public interface Piece {
    Moves getMoves();

    void moveTo(Location dest);

    void beforeMove(Location src, Location dest);

    boolean isOpponent(Colour otherColour);

    boolean isWhite();

    boolean hasNotMoved();

    void destroy();

    void setLocation(Location location);

    Moves getCaptureMoves();
}
