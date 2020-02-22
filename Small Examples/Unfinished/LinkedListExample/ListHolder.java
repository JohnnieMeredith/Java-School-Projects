
public class ListHolder {
    ListItem top;
    public ListItem getTop () {
        return top;
    }

    public String toString() {
        ListItem item = top;
        String value = "List[ ";
        while (item != null) {
            value += (item+" ");
            item=item.getNext();
        }
        value += "]";
        return value;
    }
    public void remove(ListItem prev, ListItem rem){
        if(rem!=null)
        {
            prev.setNext(rem.getNext());
            
        }
       
            
        
    }
    public void add (ListItem ins) {
        if (ins!=null) {
            ins.setNext(null);
            if (top==null || ins.compareTo(top) < 0) {
                newTop (ins);
            } else {
                ListItem prev = top;
                ListItem curr = top.getNext();
                while (curr != null) {
                    if (ins.compareTo(curr) < 0) {
                        break;
                    }
                    prev = curr;
                    curr = curr.getNext();
                }
                insert(prev,ins);
            }
        }
    }

    private void newTop (ListItem ins) {
        ins.setNext(top);
        top = ins; 
    }

    private void insert (ListItem prev, ListItem ins) {
        ins.setNext(prev.getNext());
        prev.setNext(ins);
    }

    public static void main () {
        ListHolder holder = new ListHolder();
        holder.add(new ListItem("Dave"));
        System.out.println(holder);
        holder.add(new ListItem("Albert"));
        System.out.println(holder);
        holder.add(new ListItem("Earl"));
        System.out.println(holder);
        holder.add(new ListItem("Betty"));
        System.out.println(holder);
    }
}
