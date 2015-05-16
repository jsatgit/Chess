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
        this.whitePlayer.setGame(this);
        this.whitePlayer.setColour(Colour.WHITE);
        this.whitePlayer.setBoard(board);
        return this;
    }

    public Game withBlackPlayer(Player player) {
        this.blackPlayer = player;
        this.blackPlayer.setGame(this);
        this.blackPlayer.setColour(Colour.BLACK);
        this.blackPlayer.setBoard(board);
        return this;
    }

    public Piece pieceAt(Location location) {
        return board.get(location);
    }

    public Game withPieces(List<Piece> pieces) {
        for (Piece piece : pieces) {
            piece.setBoard(board);
            board.place(piece, piece.getLocation());
            whitePlayer.addPiece(piece);
            blackPlayer.addPiece(piece);
        }
        return this;
    }

    public Game start() {
        this.currentPlayer = whitePlayer; 
        this.whitePlayer.setOtherPlayer(blackPlayer);
        this.blackPlayer.setOtherPlayer(whitePlayer);
        return this;
    }

    public void move(Location src, Location dest) {
        board.move(src, dest); 
        display.show();
    }

    public boolean isMyTurn(Player player) {
        return currentPlayer == player;
    } 

    private boolean isCheckMate() {
        return false; 
    }

    private void gameOver() {
    }
    
    public void onMoveEnd() {
        if (isCheckMate()) {
            gameOver(); 
        } else {
            currentPlayer = currentPlayer.getOtherPlayer(); 
        }
    }
}
