
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    Item next;
    String payload;
    int count;
    /**
     * Constructor for objects of class Item
     */
    public Item(String data)
    {
        // initialise instance variables
        payload = data;
        next = null;
    }
    public Item getNext(){
        return next;
    }
    public void setNext(Item i){
        this.next = i;
    }
    public String toString(){
        return this.payload;
    }
    public int compareTo(Item other){
        return this.payload.compareTo(other.payload);
    }
    public void incrementCounter(){
        count++;
    }
    public void decrementCounter(){
        count++;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main()
    {
        // put your code here
      
    }
}
