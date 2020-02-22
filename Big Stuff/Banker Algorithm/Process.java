import java.util.*;
/**
 * Process models a process running on a system with its name and features
 *
 * @author Johnnie Meredith 
 * @version 3/29/19
 */
public class Process
{
    // instance variables - replace the example below with your own
    private int name;
    private int max[], need[], alloc[];
    private int resourceTotal;
    private boolean isFinished;
    /**
     * Constructor for objects of class Process
     * @param name an integer to distinguish this process from others
     * @param rT the resource array representing the system resources
     */
    public Process(int name, Resource[] rT)
    {
        // initialise instance variables
        this.name = name;
        this.resourceTotal = rT.length;
        this.max = new int[resourceTotal];
        this.need = new int[resourceTotal];
        this.alloc = new int[resourceTotal];
        this.isFinished = false;
        setupMax(rT);
        setupAlloc(rT);
    }

    /**
     * Fills the need matrix and returns it
     *
     * 
     * @return    the resources needed to finish this process in a matrix
     */
    public int[] computeNeed()
    {
        // put your code here
        for(int i = 0; i < this.resourceTotal; i++)
        {
            this.need[i] = this.max[i] - this.alloc[i];
        }
        return this.need;
    }

    /**
     * Whether this process can finish given an amount of resources
     *
     * @param  r the matrix representing available resources
     * @return    true if it can finish
     */
    public boolean canFinish(Resource[] r)
    {
        this.need = this.computeNeed();
        boolean b = true;
        for(int i = 0; i < this.resourceTotal; i++)
        {
            if(r[i].getAvailable() >= this.need[i] && (b == true) )
            {
                b = true;
            }
            else
                b = false;

        }
        return b;
    }
    
    /**
     * Defines a matrix which describes the total resources that this process needs to finish
     *
     * @param  r a resource matrix
     * 
     */
    public void setupMax(Resource[] r)
    {
        for(int x = 0; x < r.length; x++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the maximum resources process " + this.name + " can use of resource " +
                r[x].getName() + ".");
            int temp =  sc.nextInt();
            
            while(temp <0)
            {
                System.out.println("Cannot make a process use negative resource.");
                System.out.println("Please enter the maximum resources process " + this.name + " can use of resource " +
                    r[x].getName() + ".");
                temp =  sc.nextInt();
                max[x] = temp; 
            }
            while(temp > r[x].getMax())
            {
                System.out.println("That would exceed the total amount of that resource the system has.");
                System.out.println("Please enter the maximum resources process " + this.name + " can use of resource " +
                    r[x].getName() + ".");
                temp =  sc.nextInt();
                max[x] = temp; 
            }
            max[x] = temp;
        }
    }

    /**
     * Sets up the initial amount of each resource allocated to this process
     *
     * @param  r a resource matrix
     * 
     */
    public void setupAlloc(Resource[] r)
    {
        for(int x = 0; x < r.length; x++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Process " + this.getName() +  " is currently allocated what amount of resource " +
                r[x].getName() + "?");
            int temp = sc.nextInt();
            while(temp < 0)
            {
                System.out.println("cannot allocate negative amounts of resource " + this.name + " .");
                System.out.println("Process " + this.getName() +  " is currently allocated what amount of resource " +
                    r[x].getName() + "?");
                temp = sc.nextInt();

            }
            while(temp > r[x].getAvailable())
            {
                System.out.println("tried to take too much of resource " + this.name + " .");
                System.out.println("Process " + this.getName() +  " is currently allocated what amount of resource " +
                    r[x].getName() + "?");
                temp = sc.nextInt();

            }
            this.alloc[x] = temp;
            r[x].allocate(temp);
        }
    }

    /**
     * process which checks whether this can finish and outputs verification that it has finished and released its resources
     *
     * @param  r a resource matrix
     * 
     */
    public void finish(Resource[] r)
    {
        boolean finish = true;
        for(int x = 0; x < r.length; x++)
        {
            if(r[x].getAvailable() >= this.need[x] && (finish == true))
            {
                finish = true;
            }
            else
                finish = false;

        }
        if(finish)
        {
            for(int x = 0; x < r.length; x++)
            {
                this.alloc[x] = this.alloc[x] + this.need[x];
                r[x].allocate( this.need[x]);
            }
            System.out.println(this);
            System.out.println("Process " + this.name + " has finished. Reclaiming resources...");
            for(int x = 0; x < r.length; x++)
            {
                r[x].reclaim(alloc[x]);
            }
            this.isFinished = true;
        }
        else
            System.out.println("Process " + this.name + " tried but cannot finish!");
    }

    /**
     * Used to kill a resource to resolve a Deadlock
     *
     * @param  r the resource matrix
     * 
     */
    public void killRelease(Resource[]r)
    {
        System.out.println("Process " + this.name + " was killed because of a Deadlock. Reclaiming resources...");
        for(int x = 0; x < r.length; x++)
        {
            r[x].reclaim(alloc[x]);
        }
        this.isFinished = true;
    }

    /**
     * Easy way to get this resource designation in string form
     *
     * 
     * @return    the name of this process
     */
    public String getName()
    {
        return String.valueOf(name);
    }

    /**
     * gets the need matrix of this process
     *
     *
     * @return    int matrix representing the current needs of this process for each resource
     */
    public int[] getNeed()
    {
        return this.need;
    }

    /**
     * gets the total resource matrix needed by this process to finish
     *
     *
     * @return    int matrix representing the total needs of this process for each resource
     */
    public int[] getMax()
    {
        return this.max;
    }

    /**
     * gets the allocation(currently held) resources by this process
     *
     *
     * @return    int matrix representing the held resources of this process 
     */
    public int[] getAlloc()
    {
        return this.alloc;
    }

    /**
     * Way to tell if this process has finished
     *
     *
     * @return    true if this process has finsished
     */
    public boolean getFinishedState()
    {
        return this.isFinished;
    }

    /**
     * Way to print this process and its held resources
     *
     *
     * @return    string representing this process and its allocated resources
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Process " + this.name + ": ");
        for(int x = 0; x < this.alloc.length; x++)
        {
            s.append("Resource " + x + ": [" + alloc[x] + "] ");
        }
        return s.toString();
    }
}
