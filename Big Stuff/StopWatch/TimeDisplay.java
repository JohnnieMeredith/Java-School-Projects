import javax.swing.*;
/**
 * Updates the time display of StopWatchApp
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TimeDisplay extends JLabel
{
    Long millisec;
    /**
     * Constructor for objects of class TimeDisplay
     */
    public TimeDisplay()
    {
       millisec = new Long(0);
       resetText();
    }
    
    public void resetText()
    {
        this.setText(millisec.toString());
    }
    public void setCurrent(long ms)
    {
        this.millisec = new Long(ms);
        resetText();

    }
    public long getCurrent()
    {
       return millisec.longValue(); 
    }
    
    
    
}
