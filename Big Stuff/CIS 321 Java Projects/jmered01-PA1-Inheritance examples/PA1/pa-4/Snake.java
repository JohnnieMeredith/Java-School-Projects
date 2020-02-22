
/**
 * Snake is a type of pet.
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

public class Snake extends Pet
{
    private String name;
    private boolean poisonous;
    private boolean nocturnal;
    private String diet;
    private boolean flies;
    public Snake()
    {
        super();
    }
    public Snake(String name, boolean poisonous, boolean nocturnal, String diet, boolean flies)
    {
        super(name, poisonous, nocturnal, diet, flies);
    }
    
    public String getName()
    {
        return name;
    }

    public boolean getPoisonous()
    {
        return this.poisonous;
    }

    public boolean getNocturnal()
    {
        return this.nocturnal;
    }

    public boolean getFlies()
    {
        return this.flies;
    }

    public String getDiet()
    {
        return this.diet;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPoisonous(boolean poisionous)
    {
        this.poisonous = poisonous;
    }

    public void setNocturnal(boolean nocturnal)
    {
        this.nocturnal = nocturnal;
    }

    public void setFlies(boolean flies)
    {
        this.flies = flies;
    }

    public void setDiet(String diet)
    {
        this.diet = diet;
    }
}
