
/**
 * Write a description of class Widget here.
 *
 * @author Johnnie Meredith
 * @version 04/01/2019
 */
public class Widget
{
    // instance variables 
    private static final double PROFIT = 0.5;   //per problem spec
    private final double cost;

    /**
     * Constructor for objects of class Widget
     */
    
    public Widget(double cost)//constructor that initializes the cost of this widget
    {
        this.cost = cost;
    }
    
    /**
     * returns the rate of profit for Widgets
     */
    public static double getProfit()
    {
        return PROFIT;
    }
    
    /**
     * returns the cost of this Widget
     */
    public double cost()
    {
        return this.cost;
    }
    
    /**
     * Constructs a string representation of this Widget and returns it
     */
    public String toString()//—to return this string: 
    {
        return "Widget{" + "cost=" + cost + '}';
    }
}
