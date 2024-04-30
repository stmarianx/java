package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Bag {
    private List<Token> tokens = Collections.synchronizedList(new LinkedList<>());

    public Bag(int n) {
        // Generate all distinct pairs of numbers between 1 and n
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tokens.add(new Token(i, j));
                }
            }
        }
        Collections.shuffle(tokens);
    }

    public synchronized Token extractToken() {
        if (!tokens.isEmpty()) {
            return tokens.remove(0);
        }
        return null;
    }
}
