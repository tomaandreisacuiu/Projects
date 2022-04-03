
/**
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   22.10.2021
 * @group  71
 * 
 * assignment copyright Kees Huizing
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Patch extends JPanel implements MouseListener {
    private boolean cooperating;
    private ArrayList<Patch> patchNeighbours = new ArrayList<>();
    private boolean prevStrategy;
    private double score;
    private double alpha;
    private boolean extra;

    public Patch(boolean initialStrategy) {
        this.cooperating = initialStrategy;
        this.prevStrategy = initialStrategy;
        this.addMouseListener(this);
    }

    public void setNeighbour(Patch p) {
        this.patchNeighbours.add(p);
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    // returns true if and only if patch is cooperating
    boolean isCooperating() {
        if (this.cooperating) {
            return true;
        } else {
            return false;
        }
    }

    // set strategy to C if isC is true and to D if false
    void setCooperating(boolean isC) {
        this.prevStrategy = this.cooperating;
        this.cooperating = isC;
    }

    public void setPrevStrategy(boolean previousS) {
        this.prevStrategy = previousS;
    }

    // change strategy from C to D and vice versa
    void toggleStrategy() {
        if (cooperating) {
            cooperating = false;
        } else {
            cooperating = true;
        }
    }

    // sets score of this patch in current round
    public void getScore() {
        int coopNeighbours = 0;
        for (Patch p : patchNeighbours) {
            if (p.isCooperating()) {
                coopNeighbours++;
            }
        }
        if (this.cooperating) {
            score = coopNeighbours;
        } else {
            score = alpha * coopNeighbours;
        }
    }

    public double returnScore() {
        return this.score;
    }

    public void newStrategy() {
        double max = score;
        boolean isCooperating = this.cooperating;
        for (Patch p : patchNeighbours) {
            if (max < p.returnScore()) {
                max = p.returnScore();
                isCooperating = p.isCooperating();
            }
        }

        if (extra) {
            if (max > this.score) {
                this.setCooperating(isCooperating);
            }
        } else {
            this.setCooperating(isCooperating);
        }
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public void paintComponent(Graphics g) {
        if (cooperating == false && prevStrategy == false) {
            g.setColor(Color.RED);
        } else if (cooperating == true && prevStrategy == true) {
            g.setColor(Color.BLUE);
        } else if (cooperating == true && prevStrategy == false) {
            g.setColor(Color.CYAN);
        } else if (cooperating == false && prevStrategy == true) {
            g.setColor(Color.ORANGE);
        }

        g.fillRoundRect(0, 0, 10, 10, 10, 5);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        this.toggleStrategy();
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}