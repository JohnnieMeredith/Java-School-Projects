
/**
 * Write a description of class WeaponCreator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WeaponCreator
{
    // instance variables - replace the example below with your own
    private int level;

    /**
     * Constructor for objects of class WeaponCreator
     */
    public WeaponCreator()
    {
        // initialise instance variables
        
    }
    public Weapon getWeapon(){
        Weapon w;
        if (level == 3){ 
        w = new Sword();
    }
        else if (level == 2){
        w = new Blade();
    }
        else
        w = new Weapon();
        return w;
    }
        
    public Launchable getProjectile(){
        get
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {
        // put your code here
        
    }
}
