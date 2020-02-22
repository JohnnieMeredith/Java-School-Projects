import java.awt.*;
import javax.swing.JFrame;
/**
 * Write a description of class Background here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Background extends Canvas
{
    // instance variables - replace the example below with your own
    int r,g,b;
    /**
     * Constructor for objects of class Background
     */
    public Background()
    {
        // initialise instance variables
        
    }
    public void draw(){
        
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Background();
        canvas.setSize(800, 800);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.fillOval(100, 100, 200, 200);
    }
}

