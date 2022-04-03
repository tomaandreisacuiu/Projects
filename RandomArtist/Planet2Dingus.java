/**
 * Planet2Dingus -- part of HA Random Artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.Graphics;

class Planet2Dingus extends Dingus {
    protected int radius;
    protected int width, height, width2, width3;
    
    public Planet2Dingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/6);
        height = 7;
        width = 2*radius;
        width2 = radius + radius/2;
        width3 = radius;
        
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(x, y, radius, radius, 0, 360);
        g.drawOval(x - radius/2, y + radius/2, width, height);
        g.drawOval(x - radius/2 + radius/4, y + radius/3, width2, height);
        g.drawOval(x - radius/2 + radius/4, y + radius - radius/3, width2, height);
        g.drawOval(x, y + radius/2 + radius/3, width3, height);
        g.drawOval(x, y + radius/2 - radius/3, width3, height);

    }
}
