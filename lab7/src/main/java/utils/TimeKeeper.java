package utils;

import game.Game;

public class TimeKeeper implements Runnable {
    private long startTime;
    private int timeLimit; // in seconds
    private Game game;

    public TimeKeeper(Game game, int timeLimit) {
        this.game = game;
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        try {
            while (System.currentTimeMillis() - startTime < timeLimit * 1000 && game.isGameRunning()) {
                Thread.sleep(1000);
                System.out.println("Time: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
            }
            if (game.isGameRunning()) {
                System.out.println("Time's up! Stopping the game.");
                game.stopGame();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
