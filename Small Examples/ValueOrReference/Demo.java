import java.util.Arrays;
/**
 * Demonstrates the difference between passing by value and passing by reference.
 *
 * @author Johnnie Meredith 
 * @version September 7 2018
 */
public class Demo
{

    public static int value;
    public static int value2;
    public static int[] reference;
    public static int swapTemp;

    public static int Demo(int x, int[] y)
    {
        x = x + 1;
        for (int z = 0; z <= 1; z++){
            y[z]++;
        }
        System.out.println("Our int output after operation change but still in the method." + " " + x);
        System.out.println("Our Array output after operation change but still in the method." + " " + Arrays.toString(y));
        return x;
    }

    public static void main() 
    {
        value = 1;
        value2 = 2;
        reference = new int [2];
        int reference[] = {1,2};
        System.out.println("This is the output of our int before it was passed to method. " + " " + value);
        System.out.println("This is the output of our array before it was passed to method. " + " " + Arrays.toString(reference));
        newLine();
        Demo(value, reference);
        newLine();
        System.out.println("The output of our int after being altered by the method but back in main is " +  value + " It has stayed the same as its original value.");
        System.out.println("Therefore, it was passed as a value just a copy of the original had been altered.");
        newLine();
        System.out.println("The output of Array after being altered by the  method but back in main is " + Arrays.toString(reference) + " It has changed to the value modified by the method.");
        System.out.println("Therefore, it was passed as a reference and the original was actually altered.");
        newLine();
        System.out.println("This method attempts to swap two values but it cannot work with int because they are passed by value. The first variable is " + value  + " and the second variable is " + value2 + ".");
        Swap(value, value2);
        System.out.println("The value of the first variable reamians " + value + " while the second value remains " + value2 + ".");
        newLine();
        System.out.println("Now let's try with the two variables of our array " + reference[0] + " and " + reference[1] + " as our first and second variable respectively");
        Swap(reference);
        System.out.println("The value of the first variable has changed to " + reference[0] + " while the second value has swapped to " + reference[1] + ".");
    }
    /** method swaps two ints (overloaded)
         * 
         */
    public static void Swap(int x, int y){
        
        swapTemp = x;
        x = y;
        y = swapTemp;
    }
   /** method swaps two values of an int array (overloaded)
         * 
         */
    public static void Swap(int[] x){
        
        swapTemp = x[1];
        x[1] = x[0]; 
        x[0] = swapTemp;
    }
    public static void newLine(){
    System.out.println();
        
    }
    

}
