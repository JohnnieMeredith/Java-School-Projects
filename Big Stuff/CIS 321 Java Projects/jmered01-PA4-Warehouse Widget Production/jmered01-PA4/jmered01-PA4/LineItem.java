
/**
 * LineItem shows a partially filled part of an order by a delivery 
 *
 * @author Johnnie Meredith
 * @version 04/01/2019
 */
public class LineItem
{
    // instance variables - replace the example below with your own
    private final int wDeliveryID;                        // (widgets) delivery id
    private final int quantityFilledFromThisDelivery;
    private final double wCostFromThisDelivery;
    /**
     * Constructor for objects of class LineItem
     */
    public LineItem(int wDeliveryID, int quantityFilledFromThisDelivery, double wCostFromThisDelivery)
    {
        // initialise instance variables
        this.wDeliveryID = wDeliveryID;
        this.quantityFilledFromThisDelivery = quantityFilledFromThisDelivery;
        this.wCostFromThisDelivery = quantityFilledFromThisDelivery*wCostFromThisDelivery*1.5;
    }
    /**
     * returns cost from a delivery represented by this lineitem
     */
    public double getCost()
    {
        return this.wCostFromThisDelivery;
    }
    /**
     * returns cost quantity from a delivery represented by this lineitem
     */
    public int getQuantity()
    {
        return this.quantityFilledFromThisDelivery;
    }
    /**
     * returns a string representation of a lineitem
     *
     */
    public String toString()
    {
        // put your code here
        return "LineItem{" + "wDeliveryID=" + wDeliveryID + ", quantityFilledFromThisDelivery=" + quantityFilledFromThisDelivery + ", wCostFromThisDelivery=" + wCostFromThisDelivery + '}';
    }
}
