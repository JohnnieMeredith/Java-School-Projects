/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlebuilder;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;


/**
 *
 * @author Melanie
 */
public class CircleBuilder extends Canvas {
    public ArrayList<Point> circle = new ArrayList<Point>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Circles");
        Canvas canvas = new CircleBuilder();
        canvas.setSize(500,500);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        
    }
    @Override
    public void paint(Graphics g){
        int x;
        int y;
        for(Point dp : circle){
             x =  2 * dp.x;
             y = 2 * dp.y;
            g.drawLine(250, 250, 250+x, 250+y);
            g.drawLine(250, 250, 250-x, 250+y);
            g.drawLine(250, 250, 250+x, 250-y);
            g.drawLine(250,250, 250-x,250-y);
        }
        
    }
    public ArrayList<Point> buildCircle(){
    
    for(int i = 0; i <= Math.PI/2; i+=Math.PI/4){
        Double x = Math.sin(i);
        int x1 = x.intValue();
        Double y = Math.cos(i);
        int y1 = y.intValue();
        Point dp = new Point(x1,y1);
        circle.add(dp);
    }
    return circle;
        
        
}
}
