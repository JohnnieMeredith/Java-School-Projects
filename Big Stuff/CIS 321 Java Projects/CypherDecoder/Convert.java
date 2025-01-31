import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * Cypher encoder/decoder.
 *
 * @author Johnnie Meredith
 * @version 1
 */
public class Convert
{
    // instance variables 
    private HashMap<Character, Character> index;   // index structure to maintain a list of words read from the file 
    private String fn;
    public ArrayList<String> text;
    /**
     * Constructor for objects of class Convert
     */
    public static void main(String[] args){
       Convert c = new Convert(args[0]);
       c.setupMap();
       c.indexFile();
       c.lineSplitter();
       
    
    }
    public Convert(String fileName)
    {
        // initialise instance variables
        this.fn = fileName;
        index = new HashMap<Character,Character>();
        text = new ArrayList<String>();
        text = indexFile();
    }
    public void setupMap(){
        for(int x = 66; x <= 90; x++){
            char t = (char)(x);
            char u = (char)(x-1);
            Character a = Character.valueOf(t);
            Character b = Character.valueOf(u);
            index.put(a,b);
        }
        Character t = (char)(65);
        Character u = (char)(90);
        index.put(t,u);
    
    for(int x = 98; x <= 122; x++){
            t = (char)(x);
            u = (char)(x-1);
            Character a = Character.valueOf(t);
            Character b = Character.valueOf(u);
            index.put(a,b);
        }
        t = (char)(97);
        u = (char)(122);
        index.put(t,u);
    }
    
    public ArrayList<String> indexFile()
    {
        
        Scanner fn;

        ArrayList<String> l = new ArrayList<String>();

        String fileName = this.fn.toLowerCase();

        
        try
        {
            fn = new Scanner(new File(fileName));
            while(fn.hasNext())
            {
                l.addAll(Arrays.asList(fn.nextLine()));
                
            }
            return l;
        }
        catch(FileNotFoundException e)
        {
            System.err.println(fileName + " was not found");
            System.exit(1);
        }
        return l;
    }
    public void lineSplitter()
    {
        /**
         * String[]n is a matrix to store the split word strings.
         */
        StringBuilder s = new StringBuilder();
        //String[] n = line.split("\\W+");
        
        for(String x: this.text)
        {
            for(int y = 0; y < x.length(); y++){
                
            s.append(find(x.charAt(y)));
            
            }
        }
    System.out.print(s);
    }
    public char find(Character w)
    {
        Character key = index.get(w);
        if (key == null) {
            return w;
        }
        else{
            return key;
        }
    }

    
   
    

}
