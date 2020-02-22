import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class Listeners here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Listeners extends Thread implements ActionListener
{
    Object stopButton;
    Object startButton;
    Object resetButton;
    TimeKeeper timeKeeper;
    TimeDisplay display;
    boolean running;
    int interval;
    long elapsedTime;
    /**
     * Constructor for objects of class Listeners
     */
    public Listeners()
    {
        // initialise instance variables
        
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
        System.out.println("stop");
        running = false;
        
    }
    else if(source == startButton){
        System.out.println("start");
        running = true;
       
        
    }
    else if(source == resetButton){
        System.out.println("reset");
        
        this.display.setCurrent(0);
       
        
    }
}
    
    public void setStarter(Object o){
        this.startButton = o;
        
    }
    public void setStopper(Object o){
        this.stopButton = o;
        
    }
    public void setReset(Object o){
        this.resetButton = o;
        
    }
    public void setDisplay( TimeDisplay t)
    {
        
        this.display = t;
        running = false;
    }
    public void setInterval(int i)
    {
        this.interval = i;
    }
     public void run () {
         try {
             while (true) { // This is an infinite loop!!!
                 Thread.sleep(interval);
                 if (running) {
                     elapsedTime = display.getCurrent() + this.interval;
                     display.setCurrent(elapsedTime);
                    }
                }
            } catch (Exception e) {
                System.err.println("Quitting now.");
            }
        }
}
 


