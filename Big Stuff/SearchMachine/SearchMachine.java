import java.util.*;
import java.math.*;
import java.lang.*;
/**
 * Write a description of class SearchMachine here.
 *
 * @author Johnnie Meredith
 * @version 10/14/2018
 */
public class SearchMachine
{
    RationalCompare[] rationalArray;
    private static  RationalCompare one;
    /**
     * Constructor for objects of class SearchMachine
     */
    public SearchMachine()
    {

    }

    public int randomInt() {
        Random random = new Random();
        return (random.nextInt(1000)+1);
    }

    public RationalCompare[] rcArrayFill(int size){
        RationalCompare[] tempRationalArray = new RationalCompare[size];
        for (int i = 0; i < tempRationalArray.length; i++) {
            tempRationalArray[i]=new RationalCompare(randomInt(),randomInt());
            //System.out.println(i + ". " + tempRationalArray[i].toString());
        }

        return tempRationalArray;
    }

    public int sequentialSearch(RationalCompare[] r){
        RationalCompare.setCount();
        for(int x = 0 ; x < r.length; x++){
            if(r[x].compareTo(one)== 0){
                return RationalCompare.getCount();

            }

            //System.out.println(sc.rationalArray[x].toString());
        }
        return RationalCompare.getCount();
    }

    public int binarySearch(RationalCompare[] r, RationalCompare key){
        RationalCompare.setCount();
        Arrays.binarySearch(r,key);
        return RationalCompare.getCount();
    }

    public int sortC(RationalCompare[] r){
        RationalCompare.setCount();
        Arrays.sort(r);
        return RationalCompare.getCount();
    }

    public static void main()
    {
        SearchMachine sc;
        sc = new SearchMachine();
        one = new RationalCompare(sc.randomInt(),sc.randomInt());
        int compare;
        System.out.println("The key we are searching for is: " + sc.one.toString() + ".");
        for(int n = 1; n <= 6; n++){
            Double arraySize = Math.pow(10, n); 
            sc.rationalArray = sc.rcArrayFill(arraySize.intValue());
            System.out.println("Value of N is " + arraySize.intValue() + ".");
            RationalCompare.setCount();
            compare = sc.sequentialSearch(sc.rationalArray);
            if(compare < sc.rationalArray.length){
                System.out.println("Sequential Search found the key in " + compare + " comparisons");
            }
            else
                System.out.println("Sequential Search did not find the key in " + compare + " comparisons.");
            compare = sc.sortC(sc.rationalArray);
            System.out.println("Sort took " + compare + " comparisons.");
            compare = sc.binarySearch(sc.rationalArray, sc.one);
            if(Arrays.binarySearch(sc.rationalArray, sc.one) > 0){
                System.out.println("Binary search found the key in " + compare + " comparisons.");
            }
            else
                System.out.println("Binary search did not find the key in " + compare + " comparisons.");
        }

    }
}
