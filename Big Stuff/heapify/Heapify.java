/**
 * Heapify takes a heap removes the smallest element and prints out the resulting heap.
 *
 * @author Johnnie Meredith
 * @version October 7, 2019
 */
public class Heapify{
    public int length;
    public static int[]heapAr;
    public Heapify(){
        
    }
    public static void main(String[] args){
              
        Heapify h = new Heapify();
        h.length = args.length;
        heapAr = new int[h.length];
        for(int x = 0; x < h.length; x++){
            heapAr[x] = Integer.valueOf(args[x]);
        }
        heap();
        for(int i = 0; i < h.length - 1; i++){
        System.out.print(heapAr[i] + " ");
        }
    }

    public static void heap(){
        
        int last = heapAr.length-1;
        swap(last, 0);
        heapAr[last] = 0;
        int parent = 0;
        last = last - 1;
        while(true){
            int leftChild = 2 * parent;
            int rightChild = leftChild + 1;
            if(leftChild >= (last)){
                break;
            }
            int minChild = leftChild;
            if((rightChild < last) && (heapAr[rightChild] < heapAr[leftChild])){
                minChild = rightChild;
            }
            if(heapAr[parent] > heapAr[minChild]){
                swap(parent, minChild);
                parent = minChild;
            }
            else{
                break;
            }
        }
    }
        private static void swap(int a, int b) {
            int temp = heapAr[a];
            heapAr[a] = heapAr[b];
            heapAr[b] = temp;
        }
    
}
