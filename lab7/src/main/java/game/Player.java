package game;

import model.Bag;
import model.Token;

public class Player implements Runnable {
    private String name;
    private Bag bag;
    private Game game;

    public Player(String name, Bag bag, Game game) {
        this.name = name;
        this.bag = bag;
        this.game = game;
    }

    @Override
    public void run() {
        while (game.isGameRunning() && !Thread.currentThread().isInterrupted()) {
            Token token = bag.extractToken();
            if (token == null) {
                break;
            }
            System.out.println(name + " extracted: " + token + " at " + System.currentTimeMillis());
            // Implement a short sleep to simulate time spent thinking
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
