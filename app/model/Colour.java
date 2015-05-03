package com.chess.app;

public enum Colour {
    BLACK, 
    WHITE;

    public Colour opposite() {
        return (this == WHITE) ? BLACK : WHITE; 
    }

    public boolean isWhite() {
        return this == WHITE;
    }
}
