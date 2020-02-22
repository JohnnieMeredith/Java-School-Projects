import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 * Write a description of class MyGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyGui extends JFrame
{
    private JButton newButton, newButton2, newButton3;
    private JList newList;
    private JTextField newTextField,
    freeQueryText,
    gotoText;
    private JTextArea newTextArea;
    private JSeparator newSep;
    private JComboBox newCB;
    //AbstractButton, BasicInternalFrameTitlePane, Box, Box.Filler, JColorChooser, 
    //JComboBox, JFileChooser, JInternalFrame, JInternalFrame.JDesktopIcon, 
    //JLabel, JLayer, JLayeredPane, JList, JMenuBar, JOptionPane, JPanel, 
    //JPopupMenu, JProgressBar, JRootPane, JScrollBar, JScrollPane, 
    //JSeparator, JSlider, JSpinner, JSplitPane, JTabbedPane, JTable, 
    //JTableHeader, JTextComponent, JToolBar, JToolTip, JTree, JViewport
    Vector v = new Vector();
    /**
     * Constructor for objects of class MyGui
     */
    public MyGui()
    {
        // initialise instance variables

    }

    private void buildGUI() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        newList = new JList();

        newList.setVisibleRowCount(2);
        JScrollPane teamNumberListScrollPane = new JScrollPane(newList);

        gotoText = new JTextField(3);
        freeQueryText = new JTextField(40);
        newButton = new JButton("new button");
        newButton.addActionListener (
            new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    try {

                    }
                    catch(Exception e){

                    }
                }

            }
        );
        newButton2 = new JButton("new button2");
        newButton2.addActionListener (
            new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    try {

                    }
                    catch(Exception e){

                    }
                }

            }
        );
        newButton3 = new JButton("new button3");
        newButton3.addActionListener (
            new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    try {

                    }
                    catch(Exception e){

                    }
                }

            }
        );
        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

        //Create the combo box, select item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        JComboBox newCB = new JComboBox(petStrings);
        newCB.setSelectedIndex(4);
        newCB.addActionListener(
            new ActionListener(){
            public void actionPerformed(ActionEvent b) {
            JComboBox cb = (JComboBox)b.getSource();
            String petName = (String)cb.getSelectedItem();
            JLabel l = new JLabel(petName);
            //l.updateLabel(petName);
        }
    }

    );

    JPanel first = new JPanel(new GridLayout(5,1));
    first.add(newButton);
    first.add(gotoText);
    first.add(newButton3);
    newTextField = new JTextField(15);
    JPanel second = new JPanel();
    second.setLayout(new GridLayout(5,1));
    second.add(newTextField);
    second.add(newCB);
    c.add(first);
    c.add(second);
    setSize(500,500);

    show();
}
public static void main(String[] args) {
MyGui gui = new MyGui();

gui.addWindowListener(
new WindowAdapter() {
public void windowClosing(WindowEvent e) {
System.exit(0);
}
}
);

//gui.init();
gui.buildGUI();   
}
}