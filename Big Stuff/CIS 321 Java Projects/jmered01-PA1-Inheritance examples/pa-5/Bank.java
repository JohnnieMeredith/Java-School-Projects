import java.util.*;
/**
 * Model of a bank.
 *
 * @author Johnnie Meredith
 * @version 1
 */
public class Bank
{
    // instance variables - replace the example below with your own
    public Account[] accounts = new Account[100];

    /**
     * Constructor for objects of class Bank
     */
    public Bank()
    {
        // initialise instance variables

    }

    /**
     * @param Account a the account to be added to this banks list of accounts
     */
    public void addAccount(Account a)
    {
        if(a.getAccountNumber() < accounts.length)
        {
            accounts[(a.getAccountNumber())] = a;
        }
        else
        {
            accounts = reallocate(accounts);
            addAccount(a);
        }
     }

    /**
     * @param Transaction t the transaction to process
     */
    public void makeDeposit(Transaction t)
    {
        Account a = this.getAccount(t.customerNumber);    
        t.processTran(a);

    }
    
    /**
     * @param Transaction t the transaction to process
     */
    public void makeWithdrawal(Transaction t)
    {   
        Account a = this.getAccount(t.customerNumber); 

        t.processTran(a);
    }
    
    /**
     * @param int customerNumber a customer number which you want to find an account for
     */
    public Account getAccount(int customerNumber)
    {
        return this.accounts[customerNumber];
    }
    
    /**
     * @param Account [] a a list of accounts to be resized
     */
    public Account[] reallocate(Account[] a)
    {

        Account[] accounts = new Account[a.length*2];
        for(int x = 0; x < a.length; x++)
        {
            accounts[x] = a[x];   
        }
        return accounts;
    }
 }
