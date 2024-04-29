package main;

import game.Game;
import utils.TimeKeeper;

public class Main {
    public static void main(String[] args) {
        int n = 5; // Maximum range for tokens, adjust as needed
        Game game = new Game(n);  // Initialize Game with shared Bag of tokens
        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        game.addPlayer("Player 3");

        game.startGame();

        TimeKeeper timeKeeper = new TimeKeeper(game, 300); // 5 minutes limit
        Thread timeKeeperThread = new Thread(timeKeeper);
        timeKeeperThread.setDaemon(true);
        timeKeeperThread.start();
    }
}
