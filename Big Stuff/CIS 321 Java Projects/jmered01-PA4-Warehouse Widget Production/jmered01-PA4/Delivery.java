
/**
 * Delivery contains the details for an amount of widgets received by the warehous
 *
 * @author Johnnie Meredith
 * @version 04/04/2019
 * 
 */
public class Delivery
{
    // instance variables - replace the example below with your own
    private final Widget w;
    private final int widgetDeliveryID;
    private int quantity;
    private final String delivery_date; // e.g. “03/02/2019”

    /**
     * Constructor for objects of class Delivery
     */
    public Delivery(int widgetDeliveryID, Widget w, int quantity, String delivery_date)
    {
        // initialise instance variables
        this.w = w;
        this.widgetDeliveryID = widgetDeliveryID;
        this.quantity = quantity;
        this.delivery_date = delivery_date;
    }
    
    /**
     * gets the widget from this delivery
     */
    public Widget getWidget()
    {
        return this.w;
    }
    
    /**
     * gets the quantity of widgets in this delivery
     */
    public int getQuantity()
    {
        return this.quantity;
    }
    
    /**
     * gets the widget id of the widgets included in this Delivery
     */
    public int getWidgetDeliveryID()
    {
        return this.widgetDeliveryID;
    }
    
    /**
     * legacy set quantity method
     */
    public void setQuantity(LineItem l){
        this.quantity = this.quantity - l.getQuantity();
    }
    
    /**
     * sets the remaining amount of widgets left in this Delivery
     */
    public void setQuantity(int x){
        this.quantity = x;
    }
    /**
     * Constructs and returns a string representation of this delivery
     */
    public String toString()
    {
        // put your code here
        return "Delivery{" + "w=" + w + ", widgetDeliveryID=" + widgetDeliveryID + ", quantity=" + quantity + ", delivery_date=" + delivery_date + '}';
    }
}
