
/**
 * Adult is a type of customer who is not a Senior or Student
 *
 * @author Johnnie Meredith
 * @version 1
 * 
 * @param int SAVINGS_INTEREST the interest on a savings account for an Adult
 * @param int CHECK_INTEREST the interest on a checking account for an Adult
 * @param int CHECK_CHARGE the check charge for an account for an Adult
 * @param int OVERDRAFT_PENALTY the overdraft fee for an account for an Adult
 */
public class Adult extends Customer
{
    private static final int SAVINGS_INTEREST = 1;
    private static final int CHECK_INTEREST = 1;
    private static final int CHECK_CHARGE = 20;
    private static final int OVERDRAFT_PENALTY = 50;
    /**
     * @param String name  name of the customer
     * @param String address  address of the customer
     * @param int age  age of the customer
     * @param String telephoneNumber  string representation of telephone number so that it can take any format
     * @param int customerNumber  artificially assigned number to the customer
     */
    public Adult(String name, String address, int age, String telephoneNumber, int customerNumber)
    {
        super(name, address, age, telephoneNumber, customerNumber);
    }
    
    public Adult()
    {
        super();
        
    }

    public int getSavingsInterest()
    {
        return SAVINGS_INTEREST;
    }
    
    public int getCheckInterest()
    {
        return CHECK_INTEREST;
    }
    
    public int getCheckCharge()
    {
        return CHECK_CHARGE;
    }
    
    public int getOverdraft()
    {
        return OVERDRAFT_PENALTY;
    }
}
