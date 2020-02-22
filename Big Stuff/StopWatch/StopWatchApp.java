import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
/**
 * Makes a millisecond stopwatch with a start and stop button.
 *
 * @author Johnnie Meredith
 * @version 1
 */
public class StopWatchApp extends JFrame
{
    // instance variables 
    
    TimeDisplay disp;
    TimeKeeper keeper;
    TimeUpdater updater;
    Thread timeThread;
    Button startButton, stopButton, resetButton;
    Listeners listener;
    JPanel main;
    public static final int INTERVAL_MS = 50;
    public static void main(String[] args)
    {
        StopWatchApp swa = new StopWatchApp();
    }
    
    /**
     * Constructor for objects of class StopWatchApp
     */
    public StopWatchApp()
    {
        JPanel main = new JPanel();
        JLabel m = new JLabel("Milliseconds");
        LayoutManager man = new BoxLayout(main, BoxLayout.Y_AXIS);
        int BS = 10;
        Border border = BorderFactory.createEmptyBorder(BS, BS, BS, BS);
        //Container c = getContentPane();
        //c.setLayout(new FlowLayout());
        float alignment = Component.CENTER_ALIGNMENT;
        disp = new TimeDisplay();
        startButton = new Button ("start");
        stopButton = new Button ("stop");
        resetButton = new Button("reset");
        //updater = new TimeUpdater (disp, INTERVAL_MS);
        timeThread = new Thread (updater);
        //listener = new Thread (Listener(updater));
        
        
        main.setLayout(man);
        main.setAlignmentX(alignment);
        main.setBorder(border);
        main.add(m);
        main.add(disp);
        main.add(startButton);
        main.add(stopButton);
        main.add(resetButton);
        
        listener = new Listeners();
        listener.setInterval(50);
        listener.setDisplay(disp);
        listener.setStarter(startButton);
        listener.setStopper(stopButton);
        listener.setReset(resetButton);
        startButton.addActionListener(listener);
        stopButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        listener.start(); 
           
        this.add(main);
        this.pack();
        this.setVisible(true);

    }
}
