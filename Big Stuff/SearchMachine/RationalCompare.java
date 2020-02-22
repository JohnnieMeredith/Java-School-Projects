
/**
 * Comparable Rational
 *
 * @author Johnnie Meredith
 * @version 10/10/18
 */
public class RationalCompare extends Rational implements Comparable<Rational>
{
    
    // instance variables - replace the example below with your own
    public static int compareCounter;
    /**
     * Constructor for objects of class RationalCompare
     */
    public RationalCompare(long num, long denom)
    {
        super(num,denom);
        
    }
    public int compareTo(Rational r){
        compareCounter++;
        if(this.toDouble() > r.toDouble()){
            return 1;
        }
        if(this.toDouble() < r.toDouble()){
            return -1;
        }
        else 
        
        return 0;
    }
    public static void setCount(){
        compareCounter = 0;
    }
    public static int getCount(){
        return compareCounter;
    }
    
}

