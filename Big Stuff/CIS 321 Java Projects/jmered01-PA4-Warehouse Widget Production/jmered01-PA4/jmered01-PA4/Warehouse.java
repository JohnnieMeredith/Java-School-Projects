import java.util.*;
/**
 * Write a description of class wh here.
 *
 * @author Johnnie Meredith
 * @version 04/01/2019
 */
public class Warehouse
{
    // instance variables 
    private Deque<Order> orders_to_be_filled;   // use as a queue first order in, first filled order
    private Deque<Delivery> widgets_on_hand;    // use as a stack
    /**
     * Constructor for objects of class Warehouse
     */
    public Warehouse()
    {
        // initialise instance variables
        this.orders_to_be_filled = new ArrayDeque<Order>();
        this.widgets_on_hand = new ArrayDeque<Delivery>();
    }

    /**
     * Logic for handling a receiving an Order
     * 
     * @param o - order that is received
     */
    public void receiveOrder(Order o)
    {
        //System.out.println(o);
        if(this.widgetsOnHand() > 0)
        {
            fillOrder(o);
        }
        else 
            this.orders_to_be_filled.addLast(o);
    }

    /**
     * Logic for handling a receiving a Delivery
     * 
     * @param d - delivery that is received
     */
    public void receiveDelivery(Delivery d)
    {
        if(this.orders_to_be_filled.isEmpty())
        {
            this.widgets_on_hand.push(d);
        }
        else
        {
            System.out.println(d);
            fillOrder(d);
        }
    }

    /**
     * Logic for filling an Order. Checks for available widgets and determines what to do based on that number.
     * 
     * @param o - order that is to be filled
     */
    public Order fillOrder(Order o)
    {
        int available, needed;
        if(widgetsOnHand() == 0)
        {
            printDetails(o);
            return o;
        }
        else
        {
            Delivery d = this.widgets_on_hand.pop();
            available = d.getQuantity();
            needed = o.orderQuantity() - o.getQuantityFilled();
            if(available < needed)
            {
                o.updateOrderDetail(d.getWidgetDeliveryID(),d.getQuantity(),(d.getWidget()).cost());
                fillOrder(o);
            }
            else
            {
                if(available > needed)
                {
                    o.updateOrderDetail(d.getWidgetDeliveryID(),needed,(d.getWidget()).cost());
                    d.setQuantity(available - needed);
                    this.widgets_on_hand.push(d);
                    System.out.println("processed this order:");
                    printDetails(o);
                }
                else
                {
                    o.updateOrderDetail(d.getWidgetDeliveryID(),needed,(d.getWidget()).cost());
                    printDetails(o);
                }
            }
            return o;
        }
    }

    /**
     * Logic for filling an order after a delivery is received
     * 
     * @param d - delivery to use for filling an order
     * @return an order that has been at least partially filled
     */
    private Order fillOrder(Delivery d)
    {
        Order  o = orders_to_be_filled.removeFirst();
        int available = d.getQuantity();
        int filled = o.getQuantityFilled();
        int needed = o.orderQuantity() - o.getQuantityFilled();
        if(needed  > available)
        {
            o.updateOrderDetail(d.getWidgetDeliveryID(),d.getQuantity(),d.getWidget().cost());
            System.out.println("order partially filled:");
            if(widgets_on_hand.isEmpty())
            {
                orders_to_be_filled.addFirst(o);
                return o;
            }
            else
                fillOrder(o);
        }
        else
        {
            if(available > needed)
            {
                o.updateOrderDetail(d.getWidgetDeliveryID(),needed,(d.getWidget()).cost());
                d.setQuantity(available - needed);
                System.out.println("processed this order:");
                printDetails(o);
                this.receiveDelivery(d);
            }
            else
            {
                o.updateOrderDetail(d.getWidgetDeliveryID(),needed,(d.getWidget()).cost());
                printDetails(o);
            }
        }
        return o;
    }

    /**
     * Helps print order and its details in a formatted fashion
     * 
     * @param o - order that needs to be printed
     */
    public void printDetails(Order o)
    {
        System.out.println("original order:");
        System.out.println(o);
        System.out.println("order summary:");
        System.out.print(o.getOrderDetail());
        System.out.println("quantity: " + o.getQuantityFilled() + " cost: " + o.orderCost());
        if(o.orderQuantity() > o.getQuantityFilled())
        {
            System.out.println("quantity to send: " + (o.orderQuantity() - o.getQuantityFilled()));
        }
        System.out.println("*****************");
    }

    /**
     * Calculates the total widgets that are available
     * 
     * @return the number of widgets 
     */
    public int widgetsOnHand()
    {
        int totalWidgets = 0;
        for(Delivery d: this.widgets_on_hand)
        {
            totalWidgets += d.getQuantity();
        }
        return totalWidgets;
    }
}
