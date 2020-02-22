import java.util.*;
import java.lang.StringBuilder;
/**
 * Write a description of class Order here.
 *
 * @author Johnnie Meredith
 * @version 4/01/2019
 */
public class Order
{
    // instance variables - replace the example below with your own
    private final Widget wID;
    private final int quantity_ordered;
    private int quantity_filled;
    private double cost;                         // total cost of this order
    private List<LineItem> orderDetail;          // why do we need this?
    /**
     * Constructor for objects of class Order
     */
    public Order(Widget w, int quantity)
    {
        // initialise instance variables
        this.wID = w;
        this.quantity_ordered = quantity;
        this.orderDetail = new ArrayList<LineItem>();
    }

    /**
     * returns the widget id for this order
     *
     * 
     * @return    string representation of this widget
     */
    public Widget getWidgetID()
    {
        // put your code here
        return this.wID;
    }

    /**
     * sets the quantity filled for this ordere
     *
     */
    public void setQuantityFilled (int y)
    {
        // put your code here
        this.quantity_filled = y;
    }

    /**
     * gets the quantity already filled for this order
     *
     */
    public int getQuantityFilled ()
    {
        // put your code here
        int totalFilled = 0;
        for(LineItem i:orderDetail)
        {
            totalFilled+=i.getQuantity();
        }
        return totalFilled;
    }

    /**
     * returns a string representation of this order
     *
     * @return    string with wid, quantity ordered, quantity filled, and cost.
     */
    @Override
    public String toString()
    {
        return  "Order{" + "wID=" + this.wID + ", quantity_ordered=" + this.quantity_ordered + ", quantity_filled=" + this.quantity_filled + ", total_cost=" + this.cost + '}';
    }
    
    /**
     * Updates the order with details from a delivery including id, quantity and cost.
     *
     */
    public void updateOrderDetail(int dID, int quantity, double cost)//—create a LineItem object and add it to orderDetail list
    {
        LineItem l = new LineItem(dID, quantity, cost);
        orderDetail.add(l);
        this.quantity_filled += quantity;
        this.cost+=(quantity*cost) + (quantity*cost*Widget.getProfit());
    }

    public String getOrderDetail()//display order details (all LineItems) as a string in this format: see ‘order summary” in the sample output (below)
    {
        StringBuilder s = new StringBuilder(); 
        for(LineItem i:orderDetail)
         {
             s.append(i.toString() + "\n");
             
        }
        return s.toString();
    }

    /**
     * returns the total order cost
     *
     * @return    total cost of the lineitems for this order
     */
    public double orderCost()//return total cost of this order from by delivery (tracked by LineItem)
    {
        double totalCost = 0;
        for(LineItem i:orderDetail)
        {
            totalCost+=i.getCost();
        }
        return totalCost;
    }

    /**
     * returns the ordered quantity
     *
     * @return     quantity originally ordered
     */
    public int orderQuantity()//return quantity of this order from specific delivery (tracked by LineItem)
    {
        return this.quantity_ordered;
    }
}
