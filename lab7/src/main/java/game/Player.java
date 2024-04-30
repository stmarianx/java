package game;

import model.Bag;
import model.Token;

import java.text.SimpleDateFormat;
import java.util.*;

public class Player implements Runnable {
    private String name;
    private Bag bag;
    private Game game;
    private List<LinkedList<Token>> sequences = new ArrayList<>();



    public Player(String name, Bag bag, Game game) {
        this.name = name;
        this.bag = bag;
        this.game = game;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS"); // For displaying timestamps
    @Override
    public void run() {
        while (game.isGameRunning() && !Thread.currentThread().isInterrupted()) {
            synchronized (game.getTurnObject()) {
                try {
                    while (!game.isMyTurn(this)) {
                        game.getTurnObject().wait();
                    }
                    if (!game.isGameRunning()) {
                        break;
                    }

                    Token token = bag.extractToken();
                    if (token == null) {
                        break; // Exit if no tokens are left to extract.
                    }
                    System.out.println("[" + sdf.format(new Date()) + "] " + name + " extracted token: " + token);
                    addToSequence(token);

                    game.advanceTurn();
                    game.getTurnObject().notifyAll(); // Notify other threads it's the next player's turn.
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    private void addToSequence(Token token) {
        ListIterator<LinkedList<Token>> it = sequences.listIterator();
        while (it.hasNext()) {
            LinkedList<Token> seq = it.next();
            if (seq.getLast().getSecond() == token.getFirst() && !containsNumberInSequences(token.getSecond())) {
                seq.add(token);
                if (seq.getFirst().getFirst() == token.getSecond() && seq.size() > 2) {
                    System.out.println("Closed sequence formed by " + name + ": " + seq);
                    it.remove();
                }
                return;
            }
        }

        // If token hasn't been added, start a new sequence
        LinkedList<Token> newSeq = new LinkedList<>();
        newSeq.add(token);
        sequences.add(newSeq);
    }


    private boolean containsNumberInSequences(int number) {
        // Check all sequences to ensure the number hasn't appeared
        for (LinkedList<Token> seq : sequences) {
            for (Token t : seq) {
                if (t.getFirst() == number || t.getSecond() == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getSequenceSize() {
        int maxSize = 0;
        for (LinkedList<Token> seq : sequences) {
            if (seq.size() > maxSize) {
                maxSize = seq.size();
            }
        }
        return maxSize;
    }


    public String getName() {
        return this.name;
    }

}
