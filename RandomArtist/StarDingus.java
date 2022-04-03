/**
 * StarDingus -- part of HA Random Artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.Graphics;

class StarDingus extends Dingus {
    protected int x, x2, y, y2;
    protected int x1, x3, y1, y3;
    protected int a1, a2, b1, b2;
    protected int a3, a4, b3, b4;
    protected boolean filled; //true: filled, false: outline

    public StarDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);

        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        x = random.nextInt(maxX/4);   
        y = random.nextInt(maxX/4);  
        x2 = x - 20;  
        y2 = y - 20;  
        x1 = x + (x2 - x);
        y1 = y;
        x3 = x2 - (x2 - x);
        y3 = y2;
        a1 = (x + x2)/2;
        a2 = (x1 + x3)/2;
        b1 = y;
        b2 = y2;
        b3 = (y + y2)/2;
        b4 = (y1 + y3)/2;
        a3 = x;
        a4 = x2;
        
        filled = random.nextBoolean();
        
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, x2,y2);
        g.drawLine(x1, y1, x3, y3);
        g.drawLine(a1, b1, a2, b2);
        g.drawLine(a3, b3, a4, b4);
    }
}
