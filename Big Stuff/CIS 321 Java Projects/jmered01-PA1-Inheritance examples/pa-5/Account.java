
/**
 * Write a description of class Account here.
 *
 * @author Johnnie Meredith
 * @version 1
 * 
 * @param customer the customer who owns this account
 * @param balance the amount of money in this account
 * @param accountNumber the unique assigned number to this account
 * @param transactions a record of this accounts transactions
 * @param next a variable to point to the next empty space in transaction array
 */
public  class Account
{
    Customer customer;
    private int balance;
    private int accountNumber;
    private Transaction[] transactions = new Transaction[20];
    public int next = 0;
    
    public void deposit(int deposit)
    {
        this.setBalance(this.getBalance()+deposit);
    }
    
    public void withdraw(int withdraw)
    {
        this.setBalance(this.getBalance()-withdraw);
    }
    
    public void addInterest(int rate)
    {
        this.setBalance(this.getBalance() + (this.getBalance() * rate / 100));
    }
    
    public Account(Customer customer, int accountNumber, int balance)
    {
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void setBalance(int balance)
    {
        this.balance = balance;
    }
    
    public int getBalance()
    {
        return this.balance;
    }
    
    public Customer getCustomer()
    {
        return this.customer;
    }
    
    public String toString()
    {
        String output = "Customer: " + customer.getName() + '\n' + "Telephone: " +
        customer.getTelephoneNumber() + '\n' + "Account Number: " + Integer.toString(accountNumber) +
        '\n' +"Balance: $" + getBalance()+'\n';
        return output;
    }
    
    public void setCustomer(Customer customer)
    {
       this.customer = customer; 
    }
    
    public void reallocate(Transaction[] trans)
    {
        Transaction [] transactions = new Transaction[trans.length*2]; 
        for(int x = 0; x < trans.length; x++)
        {
         transactions[x] = trans[x];   
        }
    }
    
    public int getAccountNumber()
    {
        return this.accountNumber;
    }
    
    public void addTransaction(Transaction t)
    {
        transactions[next] = t;
        next++;
    }
    
    public boolean equals(Account a)
    {
        if (this.accountNumber == a.accountNumber)
            return true;
        else
            return false;
    }
}
