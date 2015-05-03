package com.chess.app;

public class GameDriver {

    public void play() {
        Board board = new Board();
        Human human = new Human(board);
        Computer computer = new Computer(board);
        Game myGame = new Game()
            .withWhitePlayer(human)
            .withBlackPlayer(computer)
            .start();

        human.move(new Location(0,0), new Location(4,4));

        computer.autoMove();
    }
}
