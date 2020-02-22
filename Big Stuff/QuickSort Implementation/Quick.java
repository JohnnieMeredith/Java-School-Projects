import java.util.Arrays;
/**
 * Quick Sort Algorithm
 *
 * @author Johnnie Meredith
 * @version 1 September 21, 2019
 */
public class Quick
{
    
    public Quick()
    {
        
    }

    public static void main(String[] args)
    {
        int[] sort = new int[args.length];
        
        for(int x = 0; x < args.length; x++){
            sort[x]=Integer.parseInt(args[x]);
        }
        Quick q = new Quick();
        int left = 0;
        int right = sort.length - 1 ;
        q.qSort(left, right, sort);
        q.printArray(sort, right);

    }
    private void qSort(int left, int right, int[] sort){
        if(left < right){
           int part = qPart(left, right, sort);
           qSort(left, part - 1, sort);
           qSort(part + 1 , right, sort);
        }
    }
    private  int qPart(int left, int right, int[] sort){
        int pivot = sort[right]; 
        int place = (left - 1);
        int temp;
        for(int j = left; j < right; j++){
                if( sort[j] <= pivot){
                    place++;
                    temp = sort[place];
                    sort[place] = sort[j];
                    sort[j]= temp;
                }
        }
        temp = sort[place + 1];
        sort[place + 1] = sort[right];
        sort[right]= temp;
        return (place + 1);
     }
     private void printArray(int array[], int size) {
        for (int x = 0; x <= size; x++)
          System.out.print(array[x] + " ");
        
      }
}