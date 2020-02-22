/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import java.awt.Component; 
import java.awt.Color; 
 
import java.awt.Graphics2D; 
import java.util.Random;


/**
 *
 * @author Melanie
 */
public class CircleBuilder extends Component
    {
    public static ArrayList<Point> circle = new ArrayList<Point>();
    public int x;
    public int y;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.JFrame frame = new JFrame("Circles");
        Component canvas = new CircleBuilder();
        frame.setSize(500,500);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        buildCircle();
        
    }
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.CYAN);
        int c = 250;
        for(int i = 0; i < 10; i++){
            y =  (int) (Math.sqrt(10- i*i) +.5);
            g.drawLine(c+i, c+y,c+i, c+y);
            g.drawLine(c-i, c+y,c-i, c+y);
            g.drawLine(c+i, c-y,c+i, c-y);
            g.drawLine(c-i, c-y,c-i, c-y);
    }
}
      
    
    public static ArrayList<Point> buildCircle(){
    
    for(int i = 0; i <= Math.PI * 2; i+=Math.PI/4){
        Double x = 10 * Math.sin(i);
        int x1 = (x.intValue());
        Double y = 10 * Math.cos(i);
        int y1 = (y.intValue());
        Point dp = new Point(x1,y1);
        circle.add(new Point(dp));
    }
    return circle;
        
        
}
}
