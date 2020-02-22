import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Grayscale{
  public static void main(String args[])throws IOException{
    BufferedImage img = null;
    File f = null;

    //read image
    try{
      f = new File("C:\\Users\\Melanie\\Pictures\\Camera Roll\\WIN_20181128_111708.JPG");
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println(e);
    }

    //get image width and height
    int width = img.getWidth();
    int height = img.getHeight();

    //convert to grayscale
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y);
        //System.out.println(p);
        //bitwise rightshift operations to extract values
        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;
        String hex = String.format("#%02x%02x%02x", r, g, b);
        System.out.println(hex);
        //calculate average
        int avg = (r+g+b)/3;

        //replace RGB value with avg using left bit shifting
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        img.setRGB(x, y, p);
      }
    }

    //write image
    try{
      f = new File("C:\\Users\\Melanie\\Pictures\\Camera Roll\\Output.jpg");
      ImageIO.write(img, "jpg", f);
    }catch(IOException e){
      System.out.println(e);
    }
  }//main() ends here
}//class ends here