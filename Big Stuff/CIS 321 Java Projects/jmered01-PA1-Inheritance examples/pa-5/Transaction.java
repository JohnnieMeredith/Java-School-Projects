import java.util.*;
/**
 * Transaction simulates 3 types of banking transaction: Deposit, Withdraw, and Interest
 *
 * @author Johnnie
 * @version 1
 * 
 * @param int customerNumber unique number assigned to identify a customer
 * @param String transactionType type of transaction limited to: "deposit", "withdraw" or "interest"
 * @param int amount the amount of this transaction for deposit and withdraw
 * @param Date date a date object to timestamp this transaction
 * @param String fees a string telling additional fees to be assessed
 */
public class Transaction
{
    public int customerNumber;
    private String transactionType;
    private int amount;
    private Date date;
    private String fees;
    
    public Transaction(int customerNumber, String transactionType, int amount, Date date, String fees)
    {
        // initialise instance variables
        this.customerNumber = customerNumber;
        this.transactionType = transactionType;
        this.amount =  amount;
        this.date = date;
        this.fees =  fees;
    }

    /**
     * processTran models the action of processing a transaction by: determining which type of transaction,
     * use appropriate account method, and add it to the account transaction array
     * @param Account account = the account on which you ar operating
     *    
     */
    public void processTran(Account account)
    {
        // determine which type of transaction then perform it on the account and at it to that accounts transaction array
        
            if(this.transactionType == ("deposit"))
            {
                account.deposit(this.amount);
                account.addTransaction(this);
            }
            else if(this.transactionType == ("withdraw"))
            {
                account.withdraw(this.amount);
                account.addTransaction(this);
            }
            else if(this.transactionType == ("interest"))
            {
                account.addInterest(this.amount);
                account.addTransaction(this);
            }
            else
            {
                Exception e;
                System.out.println("Bad transaction type!");
            }
    }
}
