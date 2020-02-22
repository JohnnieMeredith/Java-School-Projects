import java.awt.Graphics;
import javax.swing.JPanel;
public class DrawPanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int radius = getWidth()/8;
        int r2 = radius*radius;
        int xc = 250;
        int yc = 250;
        for(int d = 1;d<=radius; d++){
            int d1 = (int) (Math.sqrt(r2 - d*d) + 0.5);
            g.fillOval(xc+d, yc+d1, 2, 2);
            g.fillOval(xc+d, yc-d1, 2, 2);
            g.fillOval(xc-d, yc+d1, 2, 2);
            g.fillOval(xc-d, yc-d1, 2, 2);
            
            g.fillOval(yc+d1, xc+d, 2, 2);
            g.fillOval(yc+d1, xc-d, 2, 2);
            g.fillOval(yc-d1, xc+d, 2, 2);
            g.fillOval(yc-d1, xc-d, 2, 2);
        }
    }
}