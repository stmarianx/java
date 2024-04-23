package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");
    // TODO: create additional buttons if necessary

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        // TODO: configure the other buttons
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);

        // Action listeners for buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        exitBtn.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent e) {
        // TODO: Implement loading game state
    }

    private void saveGame(ActionEvent e) {
        // TODO: Implement saving game state
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
