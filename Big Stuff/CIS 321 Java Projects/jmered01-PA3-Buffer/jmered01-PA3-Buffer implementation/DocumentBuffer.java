import java.util.*;
/**
 * DocumentBuffer is 
 *
 * @author Johnnie Meredith
 * @version 3/16/2019
 */
public class DocumentBuffer
{
    // instance variables 
    private List<Line> lineBuffer ;
    private final CareTaker ct;
    /**
     * Constructor for objects of class DocumentBuffer
     * 
     * @param CareTaker ct - a CareTaker object which helps with storing Memento objects
     */
    public DocumentBuffer(CareTaker ct)
    {
        // initialise instance variables
        this.ct = ct;
        lineBuffer = new ArrayList<Line>();
    }

    /**
     * Reverts the state to before the last action.
     *
     * @return    boolean - true if successful
     */
    public boolean undo()
    {
        Memento mem = this.ct.get();            //.getState();
        if(!mem.equals(null))
        {
            this.restoreStateFromMemento(mem);  //ct retrieve last momento
            return true;
        }
        else
            return false;
    }

    /**
     * Adds a line object to your list of lines
     *
     * @param Line line - the line object to be added
     * @return boolean - true if successful
     */
    public boolean addLine(Line line)
    {
        //might want to check empty string
        if(line != null)
        {
            Memento mem = this.saveStateToMomento();    //make memento out of lineBuffer
            this.ct.add(mem);                           //add the memento to the caretaker
            return this.lineBuffer.add(line);
        }
        else
            return false;
    }

    /**
     * Removes a line at the specified line number
     *
     * @param int line - the line number of the position of the line you want to remove
     * @return the line number of the removed line
     */
    public int removeLine(int line)
    {
        // put your code here
        if(this.lineBuffer.size() > line)
        {
            Memento mem = this.saveStateToMomento();    //make memento
            this.ct.add(mem);                           //store state
            this.lineBuffer.remove(line-1);             //return removed line
            return this.lineBuffer.size();
        }
        else
            return -1;
    
    }
    
    /**
     * Stores state as a Memento object
     *
     * @return Memento mem - a Memento object with the state youw want stored
     */
    private Memento saveStateToMomento()
    {
        Memento mem = new Memento(lineBuffer);
        return mem;
    }
    /**
     * Loads the state from a Memento object
     *
     * @param Memento mem - a Memento object with the state youw want restored
     */
    public void restoreStateFromMemento(Memento mem)
    {
        this.lineBuffer = (ArrayList)(mem.getState());
    }

    @Override
    public String toString()
    {
        String string = this.lineBuffer.toString().replace("[", "").replace("]", "").replace(", ", ""); //takes out the commas and brackets in the string constructed
        return string;
    }
}
