import java.util.*;
/**
 * Holds a list of previous states as Memento objects for use in DocumentBuffer
 *
 * @author Johnnie Meredith
 * @version 3/16/2019
 */
public class CareTaker
{
    // instance variables 
    private Deque<Memento> mStack;

    /**
     * Constructor for objects of class CareTaker
     */
    public CareTaker()
    {
        // initialise instance variables
        this.mStack = new ArrayDeque<Memento>();
    }

    /**
     * Adds a Memento object to your deque
     *
     * @param  Memento state - the Memento object to be added
     */
    public void add(Memento state)
    {
        this.mStack.addFirst(state);
    }

    /**
     * Gets the last Memento added to your deque
     *
     * @return Memento that holds the last state
     */
    public Memento get()
    {
        if(this.mStack.peek()!=null){
            return (this.mStack.removeFirst());
        }
        else
            return new Memento(new ArrayList<Line>());
    }
}
