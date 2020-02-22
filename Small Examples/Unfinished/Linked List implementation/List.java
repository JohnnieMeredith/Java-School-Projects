
/**
 * Write a description of class List here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class List
{
   int position; // instance variables - replace the example below with your own
   Item top;
   String s;
    /**
     * Constructor for objects of class List
     */
    public List()
    {
        // initialise instance variables
        
    }
    public void remove(Item I){
        if(I!=null){
            if
    }
    public void add(Item L){
        if(L!=null){
            L.setNext(null);
            if(top==null|| L.compareTo(top) < 0){
                newTop(L);
            }
            else{
                Item prev = top;
                Item curr = top.getNext();
                while(curr!=null){
                    if(L.compareTo(curr)<0){
                        break;
                    }
                    prev = curr;
                    curr = curr.getNext();
                }
            }
        }
    }
    public Item getTop(){
        return top;
    }
    //public String toString(){
        //Item item = top;
    //}
    
    public void insert(Item i, Item prev){
        i.setNext(prev.next);
        prev.setNext(i);
    }
    public void newTop(Item t){
        t.setNext(top);
        top = t;
        
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
