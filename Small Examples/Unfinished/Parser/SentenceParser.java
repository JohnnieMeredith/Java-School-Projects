/**
 * Write a description of class SentenceParser here.
 *
 * @author Johnnie Meredith 
 * @version Feb. 26, 2018
 */
public class SentenceParser
{
    int[] spaces = new int[1000];
    String sentence;
    int numOfWords;
    
    

    int uniqueWords;
    public SentenceParser(String sentence){
        this.sentence = sentence;
        TotalWords(sentence);
        UniqueWords(sentence);
            

    }

    public void TotalWords(String sentence){ 
        char[] letter =  sentence.toCharArray();
        for (int x = 1; x < letter.length; x++){

            if (letter[x] == (' ') && (letter[(x-1)] != (',')|| letter[(x-1)] != ('.')|| letter[(x-1)] != (' '))){
                numOfWords++;
                spaces[x]=1;
            }

            else if (letter[x] == ('.')){
                numOfWords++;
                spaces[x]=1;

            }
            else if (letter[x] == (',')){
                numOfWords++;
                spaces[x]=1;
            }
            else
                spaces[x] =0;

        }
        System.out.println(numOfWords);

    }

    public void UniqueWords(String sentence){
        int k = 0;
        int j = 1;
        String nw;
        String[] words = new String[1000];
        for (int x = 2; x <= sentence.length(); x++){
            
            if (spaces[x] != 0){
                
                nw = sentence.substring(x, k);
                System.out.println(nw);
                words[j]= nw;
                System.out.println(nw);
                j++;
                
                x=k+1;
                
            }
            
            else if(k < sentence.length() 
            k++;
        }

            for(int y = 1; y < numOfWords; y++){
                for (int w = numOfWords; w > y; w--){
                   
                    
                    if (words[y].equals(words[w])){
                        uniqueWords++;

                    }

                }    
            }
        
        System.out.println(uniqueWords);
    }
    

    //static means you can call main without bluej
    public static void main(String[] args){
        SentenceParser sp = new SentenceParser ("Peas and carrots and potatoes.");
        System.out.println(sp);
        //then print your results
        

    }

}