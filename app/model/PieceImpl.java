package com.chess.app;
import java.util.List;
import java.util.ArrayList;

public abstract class PieceImpl implements Piece {
    protected Colour colour;
    protected Location location;
    protected Board board;
    private boolean hasMoved;
    private Moves moves;
    protected List<Direction> directions;
    private Player owner;

    public PieceImpl(Player owner, Board board) {
        this.owner = owner;
        this.board = board;

        this.colour      = owner.getColour();
        this.hasMoved    = false;
        this.moves       = new Moves();

        this.owner.addPiece(this);
    }

    public void setLocation(Location location) {
       this.location = location; 
    }

    public boolean hasNotMoved() {
        return !hasMoved;
    }

    protected void checkAndAddPassing(Location location) {
        if (board.isFree(location)) {
            moves.addPassing(location); 
        }
    } 
    
    protected void checkAndAddCapturing(Location location) {
        if (board.isOccupied(location)) {
            moves.addCapturing(location); 
        }
    } 

    private void initializeMoves() {
        moves.clear();
    } 

    private void maybeAddPassing(Location testLocation, Direction direction) {
        if (direction.isForPassing(location)) {
            moves.addPassing(testLocation); 
        }
    }

    private void maybeAddCapturing(Location testLocation, Direction direction) {
        if (direction.isForCapturing(location) && 
            board.isOccupiedByOpponent(colour, testLocation)) {
            moves.addCapturing(testLocation);
        }
    }

    private void computeMovesFor(Direction direction) {
        int numMoves = 0;
        Location testLocation = direction.getNext(location);
        while (Board.isValidLocation(testLocation) && 
               direction.isWithinMoveLimit(numMoves)) {
            if (board.isFree(testLocation)) {
                maybeAddPassing(testLocation, direction);
            } else {
                maybeAddCapturing(testLocation, direction);
                break; 
            } 
            testLocation = direction.getNext(testLocation);
            numMoves++;
        }
    }

    public Moves getMoves() {
        initializeMoves();    
        for (Direction direction : directions) {
            computeMovesFor(direction); 
        }
        return moves;
    }

    public boolean isOpponent(Colour otherColour) {
       return colour != otherColour; 
    }
    
    public void beforeMove(Location src, Location dest) {
    }

    private void captureIfPieceExists(Location dest) {
        Piece piece = board.get(dest); 
        if (piece != null) {
            piece.destroy();    
        }
    }

    public void moveTo(Location dest) {
        beforeMove(location, dest);
        captureIfPieceExists(dest);
        board.movePiece(this, location, dest);
        hasMoved = true;
    }

    public boolean isWhite() {
        return colour == Colour.WHITE;
    }

    public void destroy() {
        owner.removePiece(this);
    }

    public Moves getCaptureMoves() {
        initializeMoves();    
        for (Direction direction : directions) {
            if (direction.isForCapturing()) {
                computeMovesFor(direction); 
            }
        }
        return moves;
    }

}
