/** 
 * part of HA Random artist
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   12.10.2021
 * @group  71
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Painting extends JPanel implements ActionListener {

   /*---- Randomness ----*/
    /** you can change the variable SEED if you like
     *  the same program with the same SEED will generate exactly the same sequence of pictures
     */
    final static long SEED = 37; // seed for the random number generator; any number works

    /** do not change the following two lines **/
    final static Random random = new Random( SEED ); // random generator to be used by all classes
    int numberOfRegenerates = 0;

   /*---- Screenshots ----
    * do not change
    */
    char current = '0';
    String filename = "randomshot_"; // prefix
    
   /*---- Dinguses ----*/
    ArrayList<Dingus> shapes = new ArrayList<Dingus>();
    //...

    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        //...
        
        
    }

    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g);     // clears the panel
        // draw all shapes
        // ...
        Color galaxy = new Color(4, 4, 64);
        this.setBackground(galaxy);

        for (Dingus shape: shapes) {
            shape.draw(g);
        }
    }

    /**
     * reaction to button press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( "Regenerate".equals(e.getActionCommand()) ) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot( this, filename+current++ ); // ++ to show of compact code :-)
        }
    }

    void regenerate() {
        numberOfRegenerates++; // do not change
        
        // clear the shapes list
        // ...
        shapes.clear();

        // create random shapes
        // ...
        for (int i = 0; i < 70; i++) {
            int nextShape = random.nextInt(18);
            
            switch(nextShape){
                case 0: shapes.add(new Planet2Dingus(600, 600));
                break;
                case 1: shapes.add(new TriangleDingus(800, 800));
                break;
                case 2: shapes.add(new TriangleDingus(600, 600));
                break;
                case 3: shapes.add(new StarDingus(5000, 5000));
                break;
                case 4: shapes.add(new StarDingus(6000, 6000));
                break;
                case 5: shapes.add(new StarDingus(4000, 4000));
                break;
                case 6: shapes.add(new PlanetDingus(800, 800));
                break;
                case 7: shapes.add(new StarDingus(5500, 5000));
                break;
                case 8: shapes.add(new StarDingus(6700, 6700));
                break;
                case 9: shapes.add(new StarDingus(4400, 4400));
                break;
                case 10: shapes.add(new CometDingus(800, 800));
                break;
                case 11: shapes.add(new CometDingus(600, 600));
                break;
                case 12: shapes.add(new RocketDingus(800, 800));
                break;
                case 13: shapes.add(new TriangleDingus(800, 800));
                break;
                case 14: shapes.add(new ElipseDingus(4000, 4000));
                break;
                case 15: shapes.add(new ElipseDingus(3000, 3000));
                break;
                case 16: shapes.add(new Planet2Dingus(2000, 2000));
                break;
                case 17: shapes.add(new PlanetDingus(800, 800));
                break;
            }
        }
    }

    /** 
     * saves a screenshot of a Component on disk
     *  overides existing files
     *
     * @param component - Component to be saved
     * @param name - filename of the screenshot, followed by a sequence number
     * 
     * do not change
     */
    void saveScreenshot(Component component, String name) {
        String randomInfo = ""+SEED+"+"+ (numberOfRegenerates-1); //minus 1 because the initial picture should not count
        System.out.println( SwingUtilities.isEventDispatchThread() );
        BufferedImage image =
            new BufferedImage(
                              component.getWidth(),
                              component.getHeight(),
                              BufferedImage.TYPE_INT_RGB
                             );
        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint( graphics ); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());
        
        try {
            ImageIO.write(image, "PNG", new File(name+".png"));
            System.out.println( "Saved screenshot as "+ name );
        } catch( IOException e ) {
            System.out.println( "Saving screenshot failed: "+e );
        }
    }
    
}