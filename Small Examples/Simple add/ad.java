public class ad
{
static int x;
static double y;
public ad(){
    x = 1;
    y = 2.0;
}

public String toString(){
    return super.toString();
}

public static void main(String[] args){
    ad a = new ad();
    a.x = (double) a.y;
    System.out.println(x);
}
}
