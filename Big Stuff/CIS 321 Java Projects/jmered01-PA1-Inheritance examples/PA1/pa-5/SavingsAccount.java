
/**
 * An account of type SavingsAccount
 *
 * @author Johnnie Meredith
 * @version 1
 */
public class SavingsAccount extends Account
{

    /**
     * Constructor for objects of class SavingsAccount
     */
    public SavingsAccount(Customer c, int accountNumber, int balance)
    {
      super(c, accountNumber, balance);  
    }

    /**
     * @param deposit the amount to be deposited
     */
    public void deposit(int deposit)
    {
        super.deposit(deposit);
    }
    
    /**
     * @param withdraw the amount to be withdrawn
     */
    public void withdraw(int withdraw)
    {
        super.withdraw(withdraw);
    }
    
    /**
     * @param rate interest rate as an integer
     */
    public void addInterest(int rate)
    {
        super.addInterest(rate);
    }
}
