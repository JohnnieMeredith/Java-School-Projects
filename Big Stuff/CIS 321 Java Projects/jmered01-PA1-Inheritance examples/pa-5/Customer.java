
/**
 * Customer for a bank can have only a single account.
 *
 * @author Johnnie Meredith
 * @version 1
 * 
 * @param String name the name of the customer
 * @param String address the address of the customer
 * @param int age the age of the customer
 * @param String telephoneNumber the customer telephone number(any format)
 * @param int customerNumber a uniquely assigned number that identifies a customer
 */
public abstract class Customer
{
    private String name;
    private String address;
    private int age;
    private String telephoneNumber;
    private int customerNumber;
    
    public Customer()
    {
        
    }
    
    public Customer(String name, String address, int age, String telephoneNumber, int customerNumber)
    {
       this.name = name;
       this.address = address;
       this.age = age;
       this.telephoneNumber = telephoneNumber;
       this.customerNumber = customerNumber;
    }
    
    public abstract int getSavingsInterest();
    public abstract int getCheckInterest();
    public abstract int getCheckCharge();
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return this.address;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return this.age;
    }
    
    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber =telephoneNumber;
    }
    public String getTelephoneNumber()
    {
        return this.telephoneNumber;
    }
    
    public void setCustomerNumber(int customerNumber)
    {
        this.customerNumber = customerNumber;
    }
    public int getCustomerNumber()
    {
        return this.customerNumber;
    }
    
}
