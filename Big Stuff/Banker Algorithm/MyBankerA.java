import java.util.*;
/**
 * Write a description of class MyBankerA here.
 *
 * @author Johnnie Meredith
 * @version 3/29/19
 */
public class MyBankerA
{
    // instance variables - replace the example below with your own
    private Process[] processes;
    private Resource[] resources;
    private boolean[] safe;
    /**
     * Constructor for objects of class MyBankerA
     */
    public MyBankerA()
    {
        // initialise instance variables

    }
    //how many/setup resources
    //how many/setup processes
    //initial allocation
    //check for finishable
    //give resources to next process
    //finish process
    //reclaim resources
    //go back to check for finishable
    /**
     * Determines the number of resources for this instance and creates them
     *
     *
     * 
     */
    public void setupResources()
    {
        Scanner sc = new Scanner(System.in);
        
        int res = -1;
        while(res < 0)
        {
        System.out.println("How many resources are there?");
        res = sc.nextInt();
    }
        resources = new Resource[res];
        for(int x = 0; x < res; x++)
        {
            int total = -1;
            while(total < 0)
            {
            System.out.println("What is the total amount of resource " + (x) + "?" );
            Scanner rc = new Scanner(System.in);
            total = rc.nextInt();
           
            Resource resource = new Resource(x, total);
            this.resources[x] = resource;
            if(total < 0)
            {
                System.out.println("Cannot have negative resources.");
            }
        }
        
    }
    }
    
    /**
     * Determines the number of processes for this instance and creates them
     *
     *
     * note: must do resources first
     */
    public void setupProcesses()
    {
        int proc = -1;
        while(proc < 0)
        {
            System.out.println("how many processes are there?");
            Scanner sc = new Scanner(System.in);
            proc = sc.nextInt();
        }
        if(proc >= 0)
        {
            processes = new Process[proc];
            for(int x = 0; x < proc; x++)
            {
                processes[x] = new Process(x, this.resources);
            }
        }   
        }    

    
    public void checkFinish()
    {
        this.safe = new boolean[processes.length];
        for(int y = 0; y < this.processes.length; y++)
        {
            if(this.processes[y].canFinish(this.resources))
            {
                this.safe[y]=true;
            }
            else
                this.safe[y] = false;
        }

    }

    public boolean safeState()
    {
        //boolean s = true;
        this.checkFinish();
        for(int y = 0; y < this.safe.length; y++)
        {
            if(this.safe[y] == true) //&& s == true)
            {
                return true;
            }
            //else
                //return false;

        }
        //return s;
        return false;
    }

    public Process[] removeFinished(Process[] p)
    {
        ArrayList<Process> notFinished = new ArrayList<Process>(Arrays.asList(p));
        for(int x = 0; x < p.length; x++)
        {
            if(p[x].getFinishedState()==true)
            {
                notFinished.remove(p[x]);
            }
        }
        Process[] pTemp = new Process[notFinished.size()];
        pTemp = notFinished.toArray(pTemp);
        return pTemp;
    }

    public Process[] kill(Process[] p, Resource[] r)
    {
        ArrayList<Process> notFinished = new ArrayList<Process>(Arrays.asList(p));
        for(int x = p.length-1; x >= 0  ; x--)
        {

            if(!p[x].canFinish(r))
            {
                p[x].killRelease(r);
                notFinished.remove(p[x]);
            }

        }
        Process[] pTemp = new Process[notFinished.size()];
        pTemp = notFinished.toArray(pTemp);
        return pTemp;
    }

    public void printArray(Object[] o)
    {
        if(o.length > 0)
        {
        for(int x = 0; x < o.length; x++)
        {
            System.out.println(o[x]);
        }
        }
        else
        {
            System.exit(1);
            }
    }

    public static void main(String[] args)
    {
        //how many/setup resources
        //how many/setup processes
        //initial allocation
        //check for finishable
        //give resources to next process
        //finish process
        //reclaim resources
        //go back to check for finishable
        
        MyBankerA bank = new MyBankerA();
        bank.setupResources();
        bank.setupProcesses();
        bank.printArray(bank.processes);
        bank.printArray(bank.resources);
        
        while(bank.processes.length >= 1)
        {
            bank.checkFinish();
            if(bank.safeState())
            {
                System.out.println("System is in a safe state.");
            }
            else
            {
                System.out.println("System is NOT in a safe state.");
                System.out.println("Will now attempt to kill a process...");
                bank.processes = bank.kill(bank.processes, bank.resources);
            }
            for(int x = 0; x < bank.processes.length; x++)
            {
                bank.checkFinish();
                if(bank.safe[x] == true)
                {
                        
                    bank.processes[x].finish(bank.resources);
                    bank.printArray(bank.resources);
                    bank.processes = bank.removeFinished(bank.processes);
                    bank.printArray(bank.processes);
                    x--;
                }
            }
            //bank.printArray(bank.processes);
            //bank.printArray(bank.resources);
        }
        System.out.println("All processes have finished.");
        bank.printArray(bank.processes);
        bank.printArray(bank.resources);
    }
}

