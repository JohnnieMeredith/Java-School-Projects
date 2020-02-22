import java.util.*;
import javax.swing.*;
import java.time.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Messing around with an alternate way to do a stopwatch.
 * NONWORKING
 *
 * @author Johnnie Meredith
 * @version -0.1
 */
public class TimeKeeper extends Thread implements ActionListener 
{
    static final int MINUTES_PER_HOUR = 60;
    static final int SECONDS_PER_MINUTE = 60;
    static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    private Thread thread = new Thread(this);
    LocalDateTime startTime;
    LocalDateTime currentTime;
    LocalDateTime endTime;
    boolean running;
    Object stopButton;
    Object startButton;
    /**
     * Constructor for objects of class TimeKeeper
     */
    public TimeKeeper()
    {
        // initialise instance variables
        
    }
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
}
    public void initiateTime()
    {
        LocalDateTime currentTime =  LocalDateTime.now();
    }
    public void start()
    {
        Thread thread = new Thread(this);
        thread.start();
        
        // multithreading here:
        
        
    }
    
    public boolean isRunning() {
        return this.thread.isAlive();
    }
   
    public void run() 
    {
        
        LocalDateTime startTime = LocalDateTime.now();
    while (true) {
                        
                        try {
                            

                            LocalDateTime t = LocalDateTime.now();
                            Duration duration = Duration.between(startTime,t);

                            /**long seconds = (t.getSecond() - startTime.getSecond());**/
                            
                                long seconds = duration.getSeconds();

                                long hours = seconds / SECONDS_PER_HOUR;
                                long minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE);
                                long secs = (seconds % SECONDS_PER_MINUTE);
                                System.out.println("time: hours: " + hours + " minutes: " + minutes + " seconds: " + (seconds-(minutes*60)));
                                //System.out.println("Time : " + "Hours : " + hours + " Min : " + minutes  + " Seconds : " + seconds);
                                
                               Thread.sleep(1000);
                            
                        
                        } catch (Exception e) {
                            // rare time it's OK to leave this blank
                            System.out.println("Error");
                        }
                    }
                
            

    
}
}

