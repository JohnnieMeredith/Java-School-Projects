import java.util.Arrays;
public class Sorter {
    ComparableInt[] sa;
    int filled;
    public Sorter (int m) {
        sa = new ComparableInt[m];
        filled=0;
    }
    public boolean add (int z) {
        if (filled<sa.length) {
            sa[filled++]=new ComparableInt(z);
            return true;
        }
        return false;
    }    
    public void sort () {
        Arrays.sort(sa);
    }
    public String toString () {
        return Arrays.toString(sa);
    }
    public static void main() {
        Sorter demo = new Sorter(5);
        demo.add(4);
        demo.add(2);
        demo.add(3);
        demo.add(5);
        demo.add(1);
        System.out.println("Before: "+demo);
        demo.sort();
        System.out.println("After: "+demo);
    }
}
