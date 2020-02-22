import java.util.*;
import java.lang.*;
/**
 * Word is an object which represents an english word.  It has a string representation and
 * a list of line number occurrences.
 *
 * @author Johnnie Meredith
 * @version 2/24/19
 */
public class Word
{
    // instance variables - replace the example below with your own
    private String w;
    private List<Integer>lines;

    /**
     * Constructor for objects of class Word
     */
    public Word(String word)
    {
        // initialise instance variables
        this.w = word.toLowerCase();
        lines = new ArrayList<Integer>();
    }

    /**
     * Checks if a line number already exists in the list of line numbers for this word object and
     * if it is not found the specified line number is added to that list.
     *@param int lineNo The line number to be
     * 
     */
    public boolean addLine(int lineNo)
    {
        if(this.lines.contains(lineNo))
        {
            return true;
        }
        else
        {
            this.lines.add(lineNo);
            return false;
        }
    }

    /**
     * Returns this word
     */
    public String getWord()
    {
        return this.w;
    }

    /**
     * Returns the list of line numbers for this word object.
     */
    public List<Integer> getLines()
    {
        return this.lines;
    }

    /**
     * Returns the string representation of this object which was
     * neccessary to allow equals method to take an Object type 
     */
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder(this.w + ": [");
        String string;
        for(int x = 0; x < this.lines.size(); x++)
        {
            if(x != this.lines.size()-1)
            {
                s.append(this.lines.get(x) + ", ");
            }
            else
                s.append(this.lines.get(x) + "]");
        }
        string = s.toString() ;
        return string;
    }

    /** Determines if two word objects are equivalent
     * @param Object o needed to be an object type to allow me to override in bluej.  Here it should always
     * be a word object that you wish to compare to another word object.
     */
    @Override
    public boolean equals(Object o)
    {
        if(o == this) return true;
        if(o == null) return false;
        if(this.getClass() == o.getClass())
        {
            Word other = (Word) o;
            return w.equals(other.w);
        }
        else
            return false;
    }
}
