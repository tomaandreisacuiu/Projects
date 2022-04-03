/**
 * CometDingus -- part of HA Random Artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.Graphics;

class CometDingus extends Dingus {
    protected int radius;
    protected int a1,b1,a2,b2;
    protected int a3,b3,a4,b4;
    protected int a5,b5,a6,b6;
    protected int a7,b7,a8,b8;
    protected int a9,b9,a10,b10;

    public CometDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/10);
        a1 = x + radius/2; b1 = y + radius/2; a7 = x + radius/2; b7 = y + radius/2;
        a3 = x + radius/2; b3 = y + radius/2; 
        a5 = x + radius/2; b5 = y + radius/2; a9 = x + radius/2; b9 = y + radius/2;
        b2 = y - 50;
        b4 = y - 50;
        b8 = y - 50;
        b6 = y - 30;
        b10 = y - 10;
        a2 = x - 50;
        a4 = x - 30;
        a6 = x - 50;
        a8 = x - 10;
        a10 = x - 50;
        
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(x, y, radius, radius, 0, 360);
        g.drawLine(a1, b1, a2, b2);
        g.drawLine(a3, b3, a4, b4);
        g.drawLine(a5, b5, a6, b6);
        g.drawLine(a7, b7, a8, b8);
        g.drawLine(a9, b9, a10, b10);
        
    }
}
