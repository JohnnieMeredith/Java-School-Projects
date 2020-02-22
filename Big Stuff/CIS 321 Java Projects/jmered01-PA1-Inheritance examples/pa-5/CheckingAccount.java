
/**
 * Write a description of class CheckingAccount here.
 *
 * @author Johnnie Meredith
 * @version 1
 */
public class CheckingAccount extends Account
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class CheckingAccount
     */
     public CheckingAccount(Customer c, int accountNumber, int balance)
    {
      super(c, accountNumber, balance);  
    }

    public void deposit(int deposit)
    {
        super.deposit(deposit);
    }
    
    public void withdraw(int withdraw)
    {
        super.withdraw(withdraw);
    }
    
    public void addInterest(int rate)
    {
        super.addInterest(rate);
    }
}
