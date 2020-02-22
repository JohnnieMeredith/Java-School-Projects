import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class Listeners here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Listeners implements ActionListener
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Listeners
     */
    public Listeners()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void actionPerformed(ActionEvent e)
    {
    Object source = e.getSource();
    if(source == stopButton){
        timeUpdater.stop();
    }
    else if(source == startButton){
        timeUpdater.start()
        
    }
}
}
