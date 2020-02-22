public class ComparableInt implements java.lang.Comparable<ComparableInt> {
    int x;
    public ComparableInt (int n) {
        x=n;
    }
    public int compareTo (ComparableInt s) {
        int si = s.toInt();
        if (x > si) {
            return 1;
        } else if (x < si) {
            return -1;
        }
        return 0;
    }
    public int toInt() {
        return x;
    }
    public String toString() {
        return "("+x+")";
    }
}
