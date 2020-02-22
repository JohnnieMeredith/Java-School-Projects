import java.util.*;
/**
 * My initial demonstration for this project.(deprecated)
 *
 * @author Johnnie Meredith
 * @version (a version number or a date)
 */
public class DemonstrationApp
{
    // instance variables - replace the example below with your own
    private Customer s, a, u, ban;
    
    private Account ca, sa, sav, ba;
    
    private Bank b;
    
    private Transaction t1, t2, t3;
    
    private Date date;
    /**
     * Constructor for objects of class DemonstrationApp
     */
    public DemonstrationApp()
    {
        // Create Customers of all 3 types
        s = new Senior("alice", "123 road", 65, "555-5555", 1);
        a = new Adult("stacy", "123 lane", 65, "555-1111", 2);
        u = new Student("bob", "123 street", 65, "555-3333", 3);
        
        //Create an account for each customer 
        ca = new CheckingAccount(s,1,0);
        sa = new SavingsAccount(a,2,100);
        sav = new SavingsAccount(u,3,1000);
        
        //Create a bank
        b = new Bank();
        
        //Create a date object
        date = new Date(2019, 02, 12);
    }

    /**
     * Main method - demonstrates the features of my banking app
     *
     * @param command line args
     * 
     */
    public static void main(String[] args)
    {
        //Create an instance of Demonstration app
        DemonstrationApp d = new DemonstrationApp();
        
        //Add the accounts to the bank
         d.b.addAccount(d.ca);
         d.b.addAccount(d.sa);
         d.b.addAccount(d.sav);
         
        System.out.println(d.ca.toString());
        System.out.println(d.sa.toString());
         
         //create Transactions
         d.t1 = new Transaction(1,"deposit",150, d.date, "none");
         d.t2 = new Transaction(2,"withdraw",150, d.date, "$50 Overdraft");
         d.t3 = new Transaction(3,"deposit",d.u.getSavingsInterest(), d.date, "none");
         
         //Bank makes the transactions
         d.b.makeDeposit(d.t1);
         d.b.makeWithdrawal(d.t2);
        
        System.out.println(d.ca.toString());
        System.out.println(d.sa.toString());
        
    }
}
