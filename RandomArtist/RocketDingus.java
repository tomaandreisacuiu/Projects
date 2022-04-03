/**
 * RocketDingus -- part of HA Random Artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.Color;
import java.awt.Graphics;

class RocketDingus extends Dingus {

    public RocketDingus(int maxX, int maxY) {
        super(maxX,maxY);
    }

    @Override
    void draw(Graphics g) {

        g.setColor(Color.orange);
        g.fillOval(x + 25, y + 125, 50, 200);
        g.setColor(Color.yellow);

        int[] xEngineTriangle = new int[3];
        int[] yEngineTriangle = new int[3];

        xEngineTriangle[0] = x;
        yEngineTriangle[0] = y + 250;
        xEngineTriangle[1] = x + 100;
        yEngineTriangle[1] = y + 250;
        xEngineTriangle[2] = x + 50;
        yEngineTriangle[2] = y + 75;

        g.fillPolygon(xEngineTriangle, yEngineTriangle, 3);
        g.setColor(color);
        g.fillRect(x, y, 100, 200);
        g.setColor(Color.white);

        int[] xNoseCone = new int[3];
        int[] yNoseCone = new int[3];

        xNoseCone[0] = x;
        yNoseCone[0] = y;
        xNoseCone[1] = x + 50;
        yNoseCone[1] = y - 100;
        xNoseCone[2] = x + 100;
        yNoseCone[2] = y;

        g.fillPolygon(xNoseCone, yNoseCone, 3);
        g.setColor(new Color(137, 207, 240));
        g.fillArc(x + 25, y + 50, 50, 50, 0, 360);

    }
}