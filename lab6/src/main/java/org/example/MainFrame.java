package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create and arrange the components
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this); // Instantiate the DrawingPanel

        // Add components to the frame
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    public void createGame(int rows, int cols) {
        // Remove the old canvas and create a new one with the specified rows and cols
        getContentPane().remove(canvas);
        canvas = new DrawingPanel(this);
        canvas.init(rows, cols); // Reinitialize with the new grid size

        // Add the new canvas to the frame's content pane
        getContentPane().add(canvas, BorderLayout.CENTER);

        // Revalidate and repaint the frame to show the new canvas
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
