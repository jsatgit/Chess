package com.chess.app;

public class GameDriver {

    public void play() {
        Human human = new Human();
        Computer computer = new Computer();
        Game myGame = new Game()
            .withWhitePlayer(human)
            .withBlackPlayer(computer)
            .start();

        human.move(new Location(0,0), new Location(4,4));

        computer.autoMove();
    }
}
