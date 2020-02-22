
/**
 * ShowImageDatabase shows flag images from a database we made in class using BLOBs
 * 
 * Revisions required by instructions:
 *   1). Make sure you have done database part. See handouts.
 *   2). You will have to load JDBC driver to run this program.
 *
 * @author Johnnie Meredith 
 * @version 0.1
 */


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class ShowImageDatabase extends JFrame{
    JButton button ;
    JLabel label;
    JTextField jtf;

    public ShowImageDatabase(){
    super("retrieve image from database in java");
    
    button = new JButton("Retrieve");
    button.setBounds(250,300,100,40);
    
    jtf = new JTextField();
    jtf.setBounds(360,310,100,20);
    
    label = new JLabel();
    label.setBounds(10,10,670,250);
    
    add(button);
    add(label);
    add(jtf);
    
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/northwind?user=root&password=shepherd");   //sample database we made in class connections
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select Image from countryflag where Country_Code = '"+jtf.getText()+"'");       //SQL query
                
                if(rs.next()){
                    byte[] img = rs.getBytes("Image");  // create a byte array from the BLOB image



                    //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    label.setIcon(newImage);
                }
                
                else{
                    label.setIcon(null);
                    label.setText("Flag Image Not Found!");
                    
                    //JOptionPane.showMessageDialog(null, "No Data");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        
        }
    });
    
    //JFrame setup
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.decode("#bdb76b"));
    setLocationRelativeTo(null);
    setSize(700,400);
    setVisible(true);
    } 
     
    public static void main(String[] args){
        new ShowImageDatabase();
    }
   }