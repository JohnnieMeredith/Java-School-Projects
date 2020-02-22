import java.util.*;
import java.io.*;
/**
 * Write a description of class TestClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestClass
{
    // instance variables - replace the example below with your own
    String s = ("But soft what light through yonder window breaks" + "\n" +
                "It is the east and Juliet is the sun" + "\n" +
                "Arise fair sun and kill the envious moon" + "\n" +
                "Who is already sick and pale with grief");
    String[] l = new String[100];
    File f = new File("romeo.txt");
    

    /**
     * Constructor for objects of class TestClass
     */
    public TestClass()
    {
        // initialise instance variables
        
    }

    private void lineSplitter(String line)
    {
        l = line.split("\\W+");
    }
    
    public static void main()
    {
        TestClass t = new TestClass();
        /**
        t.l.add(t.s.split("\\W+"));
        for(String x:t.s)
        {
        //t.lineSplitter(t.s,x);
        System.out.println(x);*/
        //t.lineSplitter(t.s);
        //System.out.println(t.s);
        //System.out.println(t.l.length);
        Indexer i = new Indexer("romeo.txt");
        
    }
}
