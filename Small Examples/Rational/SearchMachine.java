import java.util.*;
import java.math.*;
import java.lang.*;
/**
 * Write a description of class SearchMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SearchMachine
{
    RationalCompare[] rationalArray;
    RationalCompare one = new RationalCompare(1,1);
    /**
     * Constructor for objects of class SearchMachine
     */
    public SearchMachine()
    {
        
    }
    public int randomInt() {
        Random random = new Random();
        return (random.nextInt(100)+1);
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
    return 0;
    }
    public int binarySearch(){
        RationalCompare.setCount();
        Arrays.binarySearch(rationalArray,one);
        return RationalCompare.getCount();
        
    }
    public int sortC(RationalCompare[] r){
        RationalCompare.setCount();
        Arrays.sort(r);
        for(int x = 0; x<r.length; x++){
        //System.out.println(RationalCompare.getCount());
    }
        return RationalCompare.getCount();
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main()
    {
        SearchMachine sc;
        sc = new SearchMachine();
        int compare;
        for(int n = 1; n <= 6; n++){
        Double arraySize = Math.pow(10, n); 
        sc.rationalArray = sc.rcArrayFill(arraySize.intValue());
        System.out.println("Value of N is " + arraySize.intValue() + ".");
        sc.rationalArray[1].setCount();
        compare = sc.sequentialSearch(sc.rationalArray);
        System.out.println("Sequential Search found it in " + compare + " comparisons");
        compare = sc.sortC(sc.rationalArray);
        System.out.println("Sort took " + compare + " operations.");
        compare = sc.binarySearch();
        System.out.println("Binary search took " + compare + " operations.");
        
    }
    
}
}
