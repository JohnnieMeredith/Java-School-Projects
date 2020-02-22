import java.util.Scanner;
import java.lang.Math;
/**
 * Approximation of square root
 *
 * @author Johnnie Meredith 
 * @version 1.1
 */
public class SquareRoot
{
   /** 
    * Main method which demonstrates the others.
    * @param String[]args
    */
    public static void main(String [] args){
       System.out.println("Enter a number to see its square root approximated");
       Scanner num = new Scanner(System.in);
       int a = num.nextInt();
       /** Outputs the return value of SquareRoot
        * 
        */
       System.out.println(SquareRoot(a));
       num.close();
       
    }
    /**
     * Approximates the square root of a number.
     * @param a the number to take the square root of
     * @return the approximation of the square root 
     */
    public static double SquareRoot(double a)
    {
        double initialValue = a;
        double postValue = a/2;
        double guessDist = 0;
        int i = 1;
        do{ 
        initialValue = postValue;  
        postValue = (initialValue + (a/initialValue))/2;
        guessDist = Math.abs(postValue - initialValue);
        System.out.println("Step " + i + " Current guess is " + postValue + ".");
        System.out.println("Step " + i + " Current error of the guess is " + guessDist/a + ".");
        i++;
    }while (guessDist > 0.0001);
    
    return postValue;
   }
}

    
    

