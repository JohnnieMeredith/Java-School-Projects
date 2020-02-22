
/**
 * Students are Customers who are under age 18.
 *
 * @author Johnnie Meredith
 * @version 1
 * 
 * @param int SAVINGS_INTEREST the interest on a savings account for a Student
 * @param int CHECK_INTEREST the interest on a checking account for a Student
 * @param int CHECK_CHARGE the check charge for an account for a Student
 * @param int OVERDRAFT_PENALTY the overdraft fee for an account for a Student
 */
public class Student extends Customer
{
    private static final int SAVINGS_INTEREST = 0;
    private static final int CHECK_INTEREST = 0;
    private static final int CHECK_CHARGE = 0;
    private static final int OVERDRAFT_PENALTY = 0;
    
    public Student(String name, String address, int age, String telephoneNumber, int customerNumber)
    {
        super(name, address, age, telephoneNumber, customerNumber);
    }
    
    public Student()
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
