/**
 * PlanetDingus -- part of HA Random Artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.Graphics;

class PlanetDingus extends Dingus {
    protected int radius;
    protected int width, height;
    
    public PlanetDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        // initialize randomly the CircleDingus properties, i.e., radius and filledness
        radius = random.nextInt(maxX/6);
        height = 7;
        width = 2*radius;
        
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillArc(x, y, radius, radius, 0, 360);
        g.drawOval(x - radius/2, y + radius/2, width, height);
    }
}
