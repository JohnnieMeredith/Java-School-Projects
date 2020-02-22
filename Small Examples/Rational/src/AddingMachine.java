package src;

import java.util.*;
import java.math.*;
/**
 * Write a description of class AddingMachine here.
 *
 * @author Johnnie Meredith
 * @version 0.1 September 26, 2018
 */
public class AddingMachine
{
    // instance variables - replace the example below with your own
    private int x;
    Rational[] rationalArray = new Rational[5];
    int[] tempIntArray = new int[10];
     
    public AddingMachine()
    {
        
    }
    public int randomInt() {
        Random random = new Random();
        return (random.nextInt(100)+1);
    }
    public double getStandardDeviation(){
        for(int x = 1; x < rationalArray.length; x++){

        }
    }
    public static Rational[] randomArray(int size) {
        
        Rational[] tempRationalArray = new Rational[size];
        for (int i = 0; i < tempRationalArray.length; i++) {
            tempRationalArray[i] = new Rational(random.nextInt(100)+1,random.nextInt(100)+1);
        }
        return tempRationalArray;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main()
    {
       
    }
}
