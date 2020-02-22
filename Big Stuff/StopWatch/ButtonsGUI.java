import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Stopwatch App with added reset button
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ButtonsGUI extends JFrame
{
    TimeDisplay disp;
    TimeKeeper updater;
    //TimeUpdater updater;
    Thread timeThread;
    Button startButton, stopButton, resetButton;
    Listeners listener;
    JPanel main;
    int INTERVAL_MS = 50;
    
    private JTextField newTextField;
    private JLabel blah;
   
    
    /**
     * Constructor for objects of class ButtonsGUI
     */
    private void buildGUI() {
        {
            Container c = getContentPane();
            c.setLayout(new FlowLayout());
            TimeDisplay disp = new TimeDisplay();
            //TimeKeeper keep  = new TimeKeeper();
            disp.setOpaque(true);
            listener = new Listeners();
            listener.setDisplay(disp);
            listener.setInterval(INTERVAL_MS);
            startButton = new Button("Start");
            startButton.addActionListener (listener);
            stopButton = new Button("Stop");
            stopButton.addActionListener(listener);
            resetButton = new Button("Reset");
            resetButton.addActionListener(listener);
            listener.setStarter(startButton);
            listener.setStopper(stopButton);
            listener.setReset(resetButton);
            listener.start();
            JPanel window = new JPanel(new GridLayout(5,1));
            newTextField = new JTextField(15);
            //window.add(newTextField);
            window.add(disp);
            window.add(new JLabel("Time in Milliseconds"));
            window.add(resetButton);
            window.add(startButton);
            window.add(stopButton);
            c.add(window);
            setTitle("StopWatch");
            setSize(500,300);
            setVisible(true);
            
        }

    
    }
    public static void main(String[]args)
    {
        ButtonsGUI gui = new ButtonsGUI();
        gui.addWindowListener(
        new WindowAdapter() {
     public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    });
        gui.buildGUI(); 
}
}
