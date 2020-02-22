 

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
    Rational[] rationalArray = new Rational[10];
    Rational[] tempRationalArray = new Rational[10];
    int numTemp;
    int denTemp;
    int stdDeviation;
    public AddingMachine()
    {
        
    }
    public static int randomInt() {
        Random random = new Random();
        return (random.nextInt(100)+1);
    }
    
    public double getStandardDeviation(){
        for(int x = 1; x < rationalArray.length; x++){
            stdDeviation+= rationalArray[x].getNumerator();
            
        }
        return stdDeviation;
    }
    public static Rational[] randomArray(int size) {
        
        Rational[] tempRationalArray = new Rational[size];
        for (int i = 0; i < tempRationalArray.length; i++) {
            tempRationalArray[i] = new Rational(randomInt(),randomInt());
        }
        return tempRationalArray;
    }
    public Rational minRational(Rational[] r){
        Rational min = new Rational(1000,1);
        for(int x = 0; x < r.length-1; x++){
            System.out.println(r[x].toString());
            if (min.compareTo(r[x])==1){
                min.setNumerator(r[x].getNumerator());
                min.setDenominator(r[x].getDenominator());
            }
        }
        System.out.println(min.toString());       
        return min;
            }
    public Rational maxRational(Rational[] r){
        Rational max = new Rational(1,1000);
        for(int x = 0; x < r.length-1; x++){
            System.out.println(r[x].toString());
            if (max.compareTo(r[x])==-1){
                max.setNumerator(r[x].getNumerator());
                max.setDenominator(r[x].getDenominator());
            }
        }
        System.out.println(max.toString());       
        return max;
            }           
    public Rational average(Rational[] r){
        Rational average = new Rational(0,1);
        for(int x = 0; x < r.length; x++){
            average = (average.add(r[x])).reduce();
            System.out.println(r[x].toString() + " " + r.length + " " + average);
            
    }
    System.out.println((average.divide(new Rational(r.length,1)).toString() + " " ));
    return average.divide(new Rational(r.length,1));
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
