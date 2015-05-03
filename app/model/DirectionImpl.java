package com.chess.app;

public abstract class DirectionImpl implements Direction {
    private int reflection;
    private int maxMoves;
    private boolean forPassing;
    private boolean forCapturing;
    protected Colour colour;
    protected Board board;

    public DirectionImpl(int maxMoves) {
        this.maxMoves = maxMoves;
        this.forPassing = true;
        this.forCapturing = true;
    }

    public void setReflectionByColour(Colour colour) {
        this.reflection = (colour == Colour.WHITE) ? 1 : -1;
        this.colour = colour;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Direction withColour(Colour colour) {
        setReflectionByColour(colour);
        return this;
    }

    protected int right(int x, int step) {
        return x + step; 
    }

    protected int left(int x, int step) {
        return x - step; 
    }

    protected int upper(int y, int step) {
        return y - reflection*step; 
    }

    protected int lower(int y, int step) {
        return y + reflection*step; 
    }

    public boolean isWithinMoveLimit(int numMoves) {
        return numMoves < maxMoves; 
    }

    public Direction forPassingOnly() {
        forPassing = true;        
        forCapturing = false;        
        return this;
    }

    public Direction forCapturingOnly() {
        forCapturing = true;
        forPassing = false;
        return this;
    }
    
    public boolean isForPassing() {
        return forPassing; 
    }
    
    public boolean isForCapturing() {
        return forCapturing; 
    }

    public boolean isForPassing(Location dest) {
        return forPassing; 
    }
    
    public boolean isForCapturing(Location dest) {
        return forCapturing; 
    }

    abstract public Location getNext(Location location);
}
