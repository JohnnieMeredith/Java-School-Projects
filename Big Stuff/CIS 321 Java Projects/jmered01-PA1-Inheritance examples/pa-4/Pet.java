
/**
 * Write a description of class Pet here.
 *
 * @author Johnnie Meredith
 * @version 1
 * 
 * @param String name the pets name
 * @param boolean poisonous is the pet poisonous
 * @param boolean nocturnal is the pet nocturnal
 * @param String diet list dietary needs or special concerns
 * @param boolean flies does the pet fly
 */
public abstract class Pet
{
    // instance variables - replace the example below with your own
    private String name;
    private boolean poisonous;
    private boolean nocturnal;
    private String diet;
    private boolean flies;

    public Pet()
    {
        
    }
    public Pet(String name, boolean poisonous, boolean nocturnal, String diet, boolean flies)
    {
        // initialise instance variables
        this.setName(name);
        this.setPoisonous(poisonous);
        this.setNocturnal(nocturnal);
        this.setFlies(flies);
        this.setDiet(diet);
    }
    abstract public String getName();
    abstract public boolean getPoisonous();
    abstract public boolean getNocturnal();
    abstract public boolean getFlies();
    abstract public String getDiet();
    abstract public void setName(String name);
    abstract public void setPoisonous(boolean poisionous);
    abstract public void setNocturnal(boolean nocturnal);
    abstract public void setFlies(boolean flies);
    abstract public void setDiet(String diet);
}
