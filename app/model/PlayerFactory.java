package com.chess.app;

public class PlayerFactory {
    public static Player build(String typeOfPlayer) {
        if (typeOfPlayer.equals("human")) {
            return new Human(); 
        } else {
            return new Computer(); 
        }
    }
} 
