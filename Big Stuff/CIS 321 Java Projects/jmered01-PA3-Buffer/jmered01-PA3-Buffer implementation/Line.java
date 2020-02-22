
/**
 * Line stores a string and a line number
 *
 * @author Johnnie Meredith
 * @version 3/16/19
 */
public class Line
{
    // instance variables - replace the example below with your own
    private String text;
    private int lineNo;

    /**
     * Constructor for objects of class Line
     * 
     * @param text - text stored in this line
     * @param lineNo - the line number for this line
     */
    public Line(String text, int lineNo)
    {
        // initialise instance variables
        this.text = text;
        this.lineNo = lineNo;
    }

    @Override
    public String toString()
    {
        return this.lineNo + "> " + this.text + "\n"; 
    }

}
