
/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   22.10.2021
 * @group  71
 * 
 * assignment copyright Kees Huizing
 */

import javax.swing.*;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PlayingField extends JPanel implements ActionListener {

    private final int gridSize = 50;
    private Patch[][] grid = new Patch[gridSize][gridSize];
    private double alpha = 1.0; // defection award factor

    private Timer timer = new Timer(1000, this);

    // random number genrator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random random = new Random(SEED);

    private boolean started;
    private boolean extra;

    public PlayingField() {
        this.setLayout(new GridLayout(gridSize, gridSize));
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new Patch(random.nextBoolean());
                grid[i][j].setAlpha(alpha);
                this.add(grid[i][j]);
            }
        }
    }

    public void start() {
        try {
            timer.start();
            started = true;
        } catch (Exception e) {

        }
    }

    public void stop() {
        try {
            timer.stop();
            started = false;
        } catch (Exception e) {

        }
    }

    public void changeFrequency(int time) {
        timer.stop();
        timer = new Timer(time, this);
        if (started) {
            timer.start();
        }
    }

    public void reset() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                boolean randomStrategy = random.nextBoolean();
                grid[i][j].setCooperating(randomStrategy);
                grid[i][j].setPrevStrategy(randomStrategy);
                grid[i][j].repaint();
            }
        }
    }

    public void setNeighbours() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j].setNeighbour(grid[Math.floorMod(i - 1, gridSize)][Math.floorMod(j - 1, gridSize)]);
                grid[i][j].setNeighbour(grid[Math.floorMod(i - 1, gridSize)][Math.floorMod(j, gridSize)]);
                grid[i][j].setNeighbour(grid[Math.floorMod(i - 1, gridSize)][Math.floorMod(j + 1, gridSize)]);
                grid[i][j].setNeighbour(grid[Math.floorMod(i, gridSize)][Math.floorMod(j - 1, gridSize)]);
                grid[i][j].setNeighbour(grid[Math.floorMod(i, gridSize)][Math.floorMod(j + 1, gridSize)]);
                grid[i][j].setNeighbour(grid[Math.floorMod(i + 1, gridSize)][Math.floorMod(j - 1, gridSize)]);
                grid[i][j].setNeighbour(grid[Math.floorMod(i + 1, gridSize)][Math.floorMod(j, gridSize)]);
                grid[i][j].setNeighbour(grid[Math.floorMod(i + 1, gridSize)][Math.floorMod(j + 1, gridSize)]);
            }
        }
    }

    /**
     * calculate and execute one step in the simulation
     */
    public void step() {
        setNeighbours();

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j].getScore();
            }
        }
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j].newStrategy();
                grid[i][j].repaint();
            }
        }
    }

    public void setAlpha(double alpha) {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j].setAlpha(alpha);
            }
        }
    }

    public double getAlpha() {
        return alpha;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j].setExtra(extra);
            }
        }
    }

    // return grid as 2D array of booleans
    // true for cooperators, false for defectors
    // precondition: grid is rectangular, has non-zero size and elements are
    // non-null
    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                resultGrid[x][y] = grid[x][y].isCooperating();
            }
        }

        return resultGrid;
    }

    // sets grid according to parameter inGrid
    // a patch should become isCooperating() if the corresponding
    // item in inGrid is true
    /*
    public void setGrid(boolean[][] inGrid) {
        // ...
    }
    */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                grid[i][j].paintComponent(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.step();
        this.repaint();
    }
}
