
/**
 * Updates time display based on an interval.
 *
 * @author Johnnie Meredith
 * @version (a version number or a date)
 */
public class TimeUpdater implements Runnable 
{
    // instance variables - replace the example below with your own
    Thread thread = new Thread(this);

    /**
     * Constructor for objects of class TimeUpdater
     */
    public TimeUpdater(TimeDisplay d, int interval)
    {
        // initialise instance variables
        
    }

    /**
     * Starts the thread
     */
    public void start()
    {
        Thread thread = new Thread(this);
        thread.start();
        
        // multithreading here:
        
        
    }
    /**
     * Checks if the thread is running
     * @return True if running
     */
    public boolean isRunning() {
        return this.thread.isAlive();
    }
    public void stop()
    {
        this.thread = null;
    }
    public void run() 
    {
        
    }
}
