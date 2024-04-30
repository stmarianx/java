package game;

import model.Bag;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Bag bag;
    private final Object turnObject = new Object();
    private volatile int currentPlayerIndex = 0;
    private volatile boolean stopGameFlag = false;
    private int n;

    public Game(int n) {
        this.n = n;
        this.bag = new Bag(n); // Initialize the bag with pairs from 1 to n
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

    // Synchronize the method to handle concurrent calls
    public synchronized void stopGame() {
        stopGameFlag = true;
        // Notify all waiting threads that the game has ended.
        synchronized (turnObject) {
            turnObject.notifyAll();
        }
        determineWinner();
    }

    public synchronized boolean isGameRunning() {
        return !stopGameFlag;
    }

    public void advanceTurn() {
        synchronized (turnObject) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            turnObject.notifyAll();
        }
    }

    public boolean isMyTurn(Player player) {
        synchronized (turnObject) {
            return players.get(currentPlayerIndex).equals(player);
        }
    }

    private void determineWinner() {
        Player winner = null;
        int maxSequenceLength = 0;
        for (Player player : players) {
            int playerSequenceSize = player.getSequenceSize();
            if (playerSequenceSize > maxSequenceLength) {
                maxSequenceLength = playerSequenceSize;
                winner = player;
            }
        }
        if (winner != null) {
            System.out.println("Winner is " + winner.getName() + " with a sequence of length: " + maxSequenceLength);
        } else {
            System.out.println("No winner, no sequences made.");
        }
    }

    public Object getTurnObject() {
        return turnObject;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
