/**
 * TriangleDingus -- part of HA Random Artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.Graphics;

class TriangleDingus extends Dingus {

    protected boolean filled; //true: filled, false: outline
    int[] x = new int[3];
    int[] y = new int[3];

    public TriangleDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);

        filled = random.nextBoolean();
        int i = 0;

        x[i] = random.nextInt(maxX);
        y[i] = random.nextInt(maxY);

        x[i + 1] = x[i] + 5;
        x[i + 2] = x[i] - 5;
        y[i + 1] = y[i] + 10;
        y[i + 2] = y[i] + 10;
        
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(x, y, 3);
    }
}