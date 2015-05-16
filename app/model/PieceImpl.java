package com.chess.app;
import java.util.List;
import java.util.ArrayList;

public abstract class PieceImpl implements Piece {
    private Player owner;
    protected Board board;
    protected Colour colour;
    private Location location;

    private boolean hasMoved;
    private Moves moves;

    protected List<Direction> directions;

    public PieceImpl(Colour colour, Location location) {
        this.colour = colour;
        this.location = location;

        this.hasMoved = false;
        this.moves = new Moves();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setLocation(Location location) {
       this.location = location; 
    }
    
    public Location getLocation() {
        return this.location;
    }

    public void setOwner(Player player) {
        this.owner = player;
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
        if (direction.isForPassing(location, board)) {
            moves.addPassing(testLocation); 
        }
    }

    private void maybeAddCapturing(Location testLocation, Direction direction) {
        if (direction.isForCapturing(location, board) && 
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
        // TODO check for legal moves
        beforeMove(location, dest);
        captureIfPieceExists(dest);
        board.move(location, dest);
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
