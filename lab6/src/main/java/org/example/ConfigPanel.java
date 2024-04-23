package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel label;
    private final JSpinner spinnerRows;
    private final JSpinner spinnerCols;
    private final JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rows = (int) spinnerRows.getValue();
                int cols = (int) spinnerCols.getValue();
                frame.createGame(rows, cols);
            }
        });
        add(label);
        add(spinnerRows);
        add(spinnerCols);
        add(createButton);
    }
}
