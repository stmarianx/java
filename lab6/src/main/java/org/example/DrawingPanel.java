package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    BufferedImage image;
    Graphics2D offscreen;

    private List<Stick> sticks;
    private Random random = new Random();
    private boolean[][] stones; // true if a stone is placed
    private Color currentPlayer; // current player color
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int stoneSize = 20;

    int padX = 10;
    int padY = 10;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.rows = 10; // Set default number of rows
        this.cols = 10; // Set default number of cols
        createOffscreenImage();
        init(this.rows, this.cols); // Initialize with the class member variables
        stones = new boolean[this.rows][this.cols]; // Use the class member variables
        currentPlayer = Color.BLACK; // Black starts
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void paintGrid(Graphics2D g) {
        // Draw horizontal and vertical lines
        g.setColor(Color.DARK_GRAY);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    public void update(Graphics g) { }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        boardWidth = canvasWidth - (2 * padX);
        boardHeight = canvasHeight - (2 * padY);
        cellWidth = boardWidth / (cols - 1);
        cellHeight = boardHeight / (rows - 1);
        stones = new boolean[rows][cols];
        sticks = new ArrayList<>();
        currentPlayer = Color.BLACK;
        randomizeSticks();
        // Calculate sizes and set preferred size
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
                repaint();
            }
        });
        repaint();
    }

    private void drawStone(int x, int y) {
        // Translate the click position to grid indices
        int col = (x - padX + cellWidth / 2) / cellWidth;
        int row = (y - padY + cellHeight / 2) / cellHeight;

        // Check if the click is within bounds and the position is free
        if (col >= 0 && col < cols && row >= 0 && row < rows && !stones[row][col]) {
            stones[row][col] = true; // Mark the stone as placed
            int drawX = padX + col * cellWidth - stoneSize / 2;
            int drawY = padY + row * cellHeight - stoneSize / 2;
            offscreen.setColor(currentPlayer);
            offscreen.fillOval(drawX, drawY, stoneSize, stoneSize);

            // Switch current player
            currentPlayer = (currentPlayer == Color.BLACK) ? Color.WHITE : Color.BLACK;

            // TODO: Implement additional game logic as needed
        }
    }
    private void randomizeSticks() {
        Random rand = new Random();
        // Create a stick between two adjacent nodes randomly
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (rand.nextBoolean()) {
                    sticks.add(new Stick(col, row, col + 1, row)); // Horizontal stick
                }
                if (rand.nextBoolean()) {
                    sticks.add(new Stick(col, row, col, row + 1)); // Vertical stick
                }
            }
        }
    }

    private void paintSticks(Graphics2D g) {
        g.setColor(Color.BLACK);
        for (Stick stick : sticks) {
            int x1 = padX + stick.x1 * cellWidth;
            int y1 = padY + stick.y1 * cellHeight;
            int x2 = padX + stick.x2 * cellWidth;
            int y2 = padY + stick.y2 * cellHeight;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(offscreen);
        paintSticks(offscreen);
        // Paint stones if they were already placed, etc.

        // Draw the offscreen image to the screen
        graphics.drawImage(image, 0, 0, this);
    }
}
