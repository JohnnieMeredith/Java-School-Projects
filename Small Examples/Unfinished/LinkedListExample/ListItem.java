
public class ListItem {
    private String payload;
    ListItem next;
    public ListItem (String data) {
        payload = data;
        next = null;
    }
    public void setNext (ListItem other) {
        next = other;
    }
    public ListItem getNext () {
        return next;
    }
    public int compareTo (ListItem other) {
        return this.payload.compareTo(other.payload);
    }
    public String toString () {
        return payload;
    }
}
