import java.io.*;
import java.util.*;
/**
 * Creates a Huffman Tree which stores letters and their corresponding Morse Codes.
 *
 * @author Johnnie Meredith
 * @version 04/26/2019
 */
public class MorseCodeTree implements Serializable 
{
    // instance variables - replace the example below with your own
    private BinaryTree<MorseCodeData> mct;
    MorseCodeData[] temp = new MorseCodeData[27];
    /**
     * Constructor for objects of class MorseCodeTree
     */
    public MorseCodeTree(String filename)
    {
        // initialise instance variables
        this.mct = new BinaryTree<MorseCodeData>();
        this.mct = this.buildMorseCodeTree(filename);
    }

    /**
     * Constructor for objects of class MorseCodeTree which makes working with subtrees easier
     */
    public MorseCodeTree(BinaryTree<MorseCodeData> mct)
    {
        // initialise instance variables
        this.mct = mct;
    }

    /**
     * Getter that returns the private BinaryTree that stores our MorseCodeData objects
     */
    public BinaryTree <MorseCodeData> getMct(){
        return this.mct;
    }

    /**
     * Called in constructor to startsbuilding our Huffman tree from a file
     * @param filename is the name of a file (must be .txt)
     * @return BinaryTree that stores MorseCodeData 
     */
    private BinaryTree <MorseCodeData> buildMorseCodeTree(String filename){
        return this.readTreeFromFile(filename);
    }

    /**
     * Helper for buildMorseCodeTree that opens the file and creates a Scanner object to pass to readBinaryTree
     * @param filename the name of a file (must be .txt)
     * @return Finished BinaryTree that stores MorseCodeData
     */
    private BinaryTree <MorseCodeData> readTreeFromFile(String filename){
        BinaryTree Md = new BinaryTree <MorseCodeData>();
        try{
            File f = new File(filename);
            Scanner s = new Scanner(f);
            Md = readBinaryTree(s);
        }catch(Exception FileNotFoundException){
            System.out.println("File does not exist or is not in the working directory.");
            System.exit(1);
        }
        //System.out.println(Md); //prints the finished tree to console for debugging
        return Md;
    }

    /**
     * Helper for readTreeFromFile that builds a tree recursively by reading each line of a scanner and constructing a MorseCodeData object
     * @param scan - a scanner created from a txt file
     * @return single BinaryTree built recursively of BinaryTrees containing MorseCodeData objects
     */
    private BinaryTree<MorseCodeData> readBinaryTree(Scanner scan) {
        MorseCodeData data;
        String s;
        s = scan.nextLine().trim();
        data = toMC(s);
        BinaryTree.Node n = new BinaryTree.Node<MorseCodeData>(data);
        // Read a line and trim leading and trailing spaces.
        //System.out.println(s);
        if (s.equals("null")) {
            return null;
        } else {
            BinaryTree<MorseCodeData> leftTree = readBinaryTree(scan);
            BinaryTree<MorseCodeData> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data, leftTree, rightTree);
        }

    }

    /**
     * Converts a string into a MorseCodeData object
     * @return MorseCodeData built from a string (has a char symbol and a string code)
     */   
    private MorseCodeData toMC(String data){// changes string data in file to node
        data.trim();
        char c = data.charAt(0);
        String s = data.substring(1).trim();
        MorseCodeData mct = new MorseCodeData(c,s);
        return mct;
    }
    /**
     * Inner Class that stores the data for our Binary tree has a char symbol and a string code
     */ 
    protected static class MorseCodeData implements Serializable {
        private final char symbol;
        private final String code;
        // public BinaryTree<MorseCodeData> left;
        //public BinaryTree<MorseCodeData> right;
        /**
         * Constructor for MorseCodeData object
         * @param symbol a letter of the alphabet
         * @param code a string code consisting of "." or "-" representing Morse code
         */
        public MorseCodeData(char symbol, String code){
            //left = null;
            //right = null;
            this.symbol = symbol;
            this.code = code;
        }
        // getters methods (your will use them in toMC() method) 
        /**
         * returns a string representation of our symbol (letter of the alphabet)
         */
        public String toString(){
            return String.valueOf(symbol);
        }

        /**
         * returns char representation of our symbol (letter of the alphabet)
         */
        public char getSymbol(){
            return this.symbol;
        }

        /**
         * returns a string representation of our code ("." or "-") represents Morse code dots and dashes
         */

        public String getCode(){
            return this.code;
        }

    }
}
