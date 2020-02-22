
/**
 * Resource models a systems resource with a name and an amount
 *
 * @author Johnnie Meredith
 * @version 3/29/19
 */
public class Resource
{
    // instance variables - replace the example below with your own
    private int max, current;
    private int name;
    /**
     * Constructor for objects of class Resource
     * @param name an int used to distinguish this resource from others
     * @param max the total amount of this resource the system has
     */
    public Resource(int name, int max)
    {
        // initialise instance variables
        this.max = max;
        this.current = max;
        this.name = name;
    }

    /**
     * takes an amount of this resource away when it is given to a process
     *
     * @param  x  the amount of resource to be allocated
     * 
     */
    public void allocate(int x)
    {
        // put your code here
        if(x <= this.current)
        {
            this.current = this.current - x;
        }   
        else
            System.out.println("tried to take too much of resource " + this.name + ".");
    }
    /**
     * returns an amount of this resource from a process
     *
     * @param  x  the amount of resource to be returned
     * 
     */
    public void reclaim(int x)
    {
        this.current = this.current + x;
    }
    
    /**
     * A simple way to get this resource designation
     *
     *
     * @return    String representation of the the resource number
     */
    public String getName()
    {
        return (String)String.valueOf(this.name);
    }

    /**
     * Gets the available amount of this resource
     *
     * 
     * @return    integer amount of this resource left
     */
    public int getAvailable()
    {
        return this.current;
    }

    @Override
    public String toString()
    {
        return "available amount of Resource " + this.name + ": [" + String.valueOf(this.current) + "]";
    }

    /**
     * Gets the total system amount of this resource
     *
     * 
     * @return    integer total amount of this resource
     */
    public int getMax()
    {
        return this.max;
    }
}
