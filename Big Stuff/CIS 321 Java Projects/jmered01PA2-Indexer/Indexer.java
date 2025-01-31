import java.util.*;
import java.io.*;
/**
 * Indexer parses a .txt document and tracks the words in it and which line numbers
 * those words occur on.
 *
 * @author Johnnie Meredith
 * @version 2/24/19
 * 
 * @param private List<Word> index is an index structure to maintain a list of words read from the file. 
 * @param private String fn is the name of the file to operate on.
 */

public class Indexer
{
    // instance variables 
    private NavigableMap<String, Word> index;   // index structure to maintain a list of words read from the file 
    private String fn;          // String File Name
    /**
     * Constructor for objects of class Indexer that stores file name
     * @param private List<Word> index is an index structure to maintain a list of words read from the file. 
     * @param private String fn is the name of the file to operate on.
     */
    public Indexer(String fileName)
    {
        // initialise instance variables
        this.fn = fileName;
        this.index = new TreeMap();
    }

    /**
     * Runs the indexFile private method
     * @return boolean true if it was successful and false if not.
     */
    public Boolean index()
    {
        try
        {
            indexFile();
            this.index.containsKey("peace");
            return true;
        }
        catch(Exception f)
        {
            System.out.println("Something went wrong... Specified file [" + this.fn + "] was not a .txt file or was empty.");
            //System.exit(1);
            return false;
        }
    }

    /**
     * Splits a line of text into individual words and stores them in the index if not present
     * or adds that line number to the word objects list of line occurrences if it is already present.
     * @param String line is a line of text to be split.
     * @param int lineNo is the line number this was pulled from in the original txt file.
     */
    private void lineSplitter(String line, int lineNo)
    {
        /**
         * String[]n is a matrix to store the split word strings.
         */
        String[] n = line.split("\\W+");
        for(int x = 0; x < n.length; x++)
        {
            /**
             * Word word is a temporary word object used to check and add new words to the list of words.
             */
            Word word = new Word(n[x]);
            if(!this.index.containsKey(word.getWord())){
                word.addLine(lineNo);
                this.index.put(word.getWord(), word);
                //this.index.get(this.index.indexOf(word)).addLine(lineNo);
            }
            else
            {
                this.index.get(word.getWord()).addLine(lineNo);
            }
        }
    }

    /**
     * Formats and prints the list of words and each words list of line number occurrences.
     * 
     */

    public void dumpList()
    {
        //for(Word w:this.index)
        //{
          //  System.out.println(w.toString());
        //}
        
        try{
        PrintWriter writer = new PrintWriter("pa5output.txt", "UTF-8");
        for (Map.Entry<String, Word > entry : this.index.entrySet()) 
        {
           writer.println(entry.getKey() + " " + find(entry.getKey()));
           System.out.println(entry.getKey() + "{" + find(entry.getKey()).size() + "}" + find(entry.getKey()));
        }
        writer.close();
    }
    catch(Exception IOException)
    {
        
    }
    }

    /**
     * Finds a specified word and prints it and its list of line number occurrences.
     * @param String w is the string you are searching for.
     */
    public List<Integer> find(String w)
    {
        Word key = index.get(w.toLowerCase());
        if (key == null) {
            return null;
        }
        else{
            List<Integer> lines = new LinkedList<>();
            ICallBack f = (int lineNo) -> lines.add(lineNo);
            key.getLines(f);
            return lines;
        }
    }
    /**
     * Opens a txt file and places it in a scanner object. The txt file is then split into 
     * strings by line. This is stored in a list.
     * @param 
     */
    private void indexFile()
    {
        /**
         * fn is a scanner object used to hold a .txt file.
         */

        Scanner fn;

        /**
         * l is a list used to hold the split lines afterward.
         */

        ArrayList<String> l = new ArrayList<String>();

        /**
         * fileName is the file to be acessed.
         */

        String fileName = this.fn.toLowerCase();

        /**
         * lineCount is a counter to keep track of line numbers. It starts at 1.
         */

        int lineCount = 1;
        try
        {
            fn = new Scanner(new File(fileName));
            while(fn.hasNext())
            {
                l.addAll(Arrays.asList(fn.nextLine()));
                if(l.get(lineCount-1).length() > 0)
                {
                    lineSplitter(l.get(lineCount-1),lineCount);
                    lineCount++;
                }
                else
                    lineCount++;
            }
        }
        catch(FileNotFoundException e)
        {
            System.err.println(fileName + " was not found");
            System.exit(1);
        }
    }
}
