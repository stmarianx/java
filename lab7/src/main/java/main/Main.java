package main;

import game.Game;
import utils.TimeKeeper;

public class Main {
    public static void main(String[] args) {
        int n = 250;
        Game game = new Game(n);
        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        game.addPlayer("Player 3");

        game.startGame();

        TimeKeeper timeKeeper = new TimeKeeper(game, 30);
        Thread timeKeeperThread = new Thread(timeKeeper);
        timeKeeperThread.setDaemon(true);
        timeKeeperThread.start();
    }
}
