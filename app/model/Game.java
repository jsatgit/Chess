package com.chess.app;

import java.util.List;

public class Game {
    private int id;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    private Board board;
    private Display display;

    public Game() {
       this.board = new Board(); 
       this.display = new Display(board);
    }

    public Game withWhitePlayer(Player player) {
        // TODO repeated code with black player
        this.whitePlayer = player;
        this.whitePlayer.setColour(Colour.WHITE);
        this.whitePlayer.setBoard(board);
        return this;
    }

    public Game withBlackPlayer(Player player) {
        this.blackPlayer = player;
        this.blackPlayer.setColour(Colour.BLACK);
        this.blackPlayer.setBoard(board);
        return this;
    }

    public Piece pieceAt(Location location) {
        return board.get(location);
    }

    private void setOwner(Piece piece) {
        if (piece.isWhite()) {
            piece.setOwner(whitePlayer);
        } else {
            piece.setOwner(blackPlayer);
        } 
    }

    public Game withPieces(List<Piece> pieces) {
        for (Piece piece : pieces) {
            piece.setBoard(board);
            setOwner(piece);
            board.place(piece, piece.getLocation());
            if (piece.isWhite()) {
                whitePlayer.addPiece(piece);
            } else {
                blackPlayer.addPiece(piece);
            }
        }
        whitePlayer.onAllPiecesAdded();
        blackPlayer.onAllPiecesAdded();
        return this;
    }

    public Game start() {
        this.currentPlayer = whitePlayer; 
        this.whitePlayer.setOtherPlayer(blackPlayer);
        this.blackPlayer.setOtherPlayer(whitePlayer);
        currentPlayer.onTurnStarted();
        return this;
    }

    public void move(Location src, Location dest) {
        currentPlayer.move(src, dest); 
        display.show();
        onMoveEnd();
    }

    public boolean isMyTurn(Player player) {
        return currentPlayer == player;
    } 

    private boolean isCheckMate() {
        return false; 
    }

    private void gameOver() {
    }
    
    private void onMoveEnd() {
        if (isCheckMate()) {
            gameOver(); 
        } else {
            currentPlayer = currentPlayer.getOtherPlayer(); 
            currentPlayer.onTurnStarted();
        }
    }
}
