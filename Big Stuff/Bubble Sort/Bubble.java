import java.util.Arrays;
/**
 * Bubble Sort Algorithm
 *
 * @author Johnnie Meredith
 * @version 1 September 9, 2019
 */
public class Bubble
{
    
    public Bubble()
    {
        
    }
    public static void main(String[] args)
    {
        int[] sort = new int[args.length];
        int answer;
        int number;
        for(int x = 0; x < args.length; x++){
            sort[x]=Integer.parseInt(args[x]);
        }
        for(int j = 0; j < sort.length; j++){
            System.out.println((Arrays.toString(sort)).replace ("[","").replace ("}","").replace (","," "));
                answer = sort[i];
                number = sort[i-1];
                if(answer < number){
                    sort[i-1] = answer;
                    sort[i] = number;
                };
            }
        }
    }
}