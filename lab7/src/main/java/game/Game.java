package game;

import model.Bag;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Bag bag;
    private int n;  // This will be used to set the range for token pairs
    private volatile boolean isRunning = true;  // Thread-safe flag to control game state

    public Game(int n) {
        this.n = n;
        this.bag = new Bag(n);  // Initialize the bag with pairs from 1 to n
    }

    public void addPlayer(String name) {
        Player player = new Player(name, this.bag, this);
        players.add(player);
    }


    public void startGame() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public void stopGame() {
        isRunning = false;  // Set the flag to false to stop all players
    }
    public boolean isGameRunning() {
        return isRunning;
    }
    // Optional: method to check game status or declare a winner
    public void checkGameStatus() {
        // This method can be called periodically or after the game concludes to determine if a player has won or to display scores.
    }
}
