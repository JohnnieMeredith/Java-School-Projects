
/**
 * Write a description of class Lambda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lambda
{
    // instance variables - replace the example below with your own
    public static int x;

    /**
     * Constructor for objects of class Lambda
     */
    public Lambda()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        // put your code here
        FuncInt f = y ->  y*2;
        printLambda(f.printInt(5));
    }
    public static void printLambda (int z){
        System.out.println(z);
    }
}

