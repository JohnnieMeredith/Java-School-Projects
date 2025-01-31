import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * Write a description of class Convert here.
 *
 * @author JM
 * @version Quick script like program to encrypt decrypt homework
 */
public class Convert
{
    // instance variables - replace the example below with your own
    private HashMap<Character, Character> index;   // index structure to maintain a list of words read from the file 
    private String fn;
    public ArrayList<String> text;
    /**
     * Constructor for objects of class Convert
     */
    public Convert(String fileName)
    {
        // initialise instance variables
        this.fn = fileName;
        index = new HashMap<Character,Character>();
        text = new ArrayList<String>();
        text = indexFile();
    }
    public void setupMap(){
        Character[] code = new Character[] {'f','y','t','h','d','i','s','g','x','k','w','j','m','n','e','v','q','a','u','b','z','o','r','l','c','p'};
        
        
        for(int x = 65; x <= 90; x++){
            // char t = (char)(x);
            // char u = (char)(x-1);
            // Character a = Character.valueOf(t);
            // Character b = Character.valueOf(u);
            // index.put(a,b);
        // }
        // Character t = (char)(65);
        // Character u = (char)(90);
        
        Character t = (char)(x);
        Character v = (char) (x+32);
        Character u  = (char) code[x-65];
        index.put(Character.toUpperCase(t),Character.toUpperCase(u));
        index.put(v,u);
    }
    
    // for(int x = 98; x <= 122; x++){
            // t = (char)(x);
            // u = (char)(x-1);
            // Character a = Character.valueOf(t);
            // Character b = Character.valueOf(u);
            // index.put(a,b);
        // }
        // t = (char)(97);
        // u = (char)(122);
        //index.put(t,u);
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
    
    public int myMethod(int x ) {
        return x+1;
    }
    public int plus(int x, Method myMethod){
        myMethod.execute(x);
    }
    
        
        
    }

    
   
    


