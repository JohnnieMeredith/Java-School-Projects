import java.util.*;
/**
 * Stores state as a list of Line objects
 *
 * @author Johnnie Meredith
 * @version 3/16/2019
 */
public class Memento
{
    // instance variables - replace the example below with your own
    private List<Line> state;

    /**
     * Constructor for objects of class Memento
     */
    public Memento(List<Line> state)
    {
        // initialise instance variables
        this.state = new ArrayList<Line>(state);
    }

    /**
     * Gets the previous state by returning the latest entry in your list of lines
     *
     * @return the next entry in your list of Line objects
     */
    public List<Line> getState()
    {
        // put your code here
        return this.state;
    }
}
