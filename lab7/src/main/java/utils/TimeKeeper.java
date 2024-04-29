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
        while (System.currentTimeMillis() - startTime < timeLimit * 1000) {
            try {
                Thread.sleep(1000);
                System.out.println("Time: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        game.stopGame();
        System.out.println("Time's up!");
    }
}
