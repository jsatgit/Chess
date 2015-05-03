package com.chess.app;

public class Game {
    private int id;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public Game withWhitePlayer(Player player) {
        this.whitePlayer = player;
        this.whitePlayer.setGame(this);
        this.whitePlayer.setColour(Colour.WHITE);
        return this;
    }

    public Game withBlackPlayer(Player player) {
        this.blackPlayer = player;
        this.blackPlayer.setGame(this);
        this.whitePlayer.setColour(Colour.BLACK);
        return this;
    }

    public Game start() {
       this.currentPlayer = whitePlayer; 
       this.whitePlayer.setOtherPlayer(blackPlayer);
       this.blackPlayer.setOtherPlayer(whitePlayer);
       return this;
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
