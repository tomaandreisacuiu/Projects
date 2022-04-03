/**
 * ElipseDingus -- part of HA Random Artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.Graphics;

class ElipseDingus extends Dingus {
    protected int width;
    protected int height;
    
    public ElipseDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        x = random.nextInt(maxX/6);
        y = random.nextInt(maxX/6);
        height = 5;
        width = 40;
        
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
        g.drawOval(x + 17, y - 16, height, width);
    }
}
