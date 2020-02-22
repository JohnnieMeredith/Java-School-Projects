
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private int x;
    public static void main(){
        Player p1 = new Player();
        WeaponCreator wc = new WeaponCreator();
        Weapon w1= new Weapon();
        p1.use(w1);
        Launchable p = wc.getProjectile();
    }
    public void use(Weapon w){
        System.out.println("Player calls......");
        w.defend();
    }
    public Launchable getProjectile(){
        p.throwMe();
    }
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
