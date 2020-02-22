/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.util.Date;

/**
 *
 * @author shasso
 */
public class BankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // create a bank
        Bank megaBank = new Bank();
        
        //create a date object
        Date d = new Date(2,2,2018);
        
        // create an Adult Customer
        Customer c = new Adult("joe smith", "chicago, IL", 34, "123-456", 101);

        // creat an Account for customer: 101
        Account acct = new SavingsAccount(c, 101, 1000);

        // add account to the bank
        megaBank.addAccount(acct);
        Account acct101 = megaBank.getAccount(101);
        System.out.println(acct101);
        System.out.println("******************");

        // deposit 200 by customer "101"
        Transaction trx = new Transaction(101, "deposit", 200, d,"none");

        // make a deposit to acct "101"
        megaBank.makeDeposit(trx);

        System.out.println(acct101);
        System.out.println("******************");

        // deposit 300 by customer "101"
        trx = new Transaction(101, "deposit", 300, d,"none");
        // make a deposit to acct "101"
        megaBank.makeDeposit(trx);
        System.out.println(acct101);
        System.out.println("******************");

        // withdraw 100 by customer "101"
        trx = new Transaction(101, "withdraw", 100, d,"none");
        // make a deposit to acct "101"
        megaBank.makeWithdrawal(trx);
        System.out.println(acct101);
        System.out.println("******************");

        // add interest
        int interest = c.getSavingsInterest();
        trx = new Transaction(101, "interest", interest, d, "none");
        megaBank.makeDeposit(trx);
        System.out.println(acct101);
        System.out.println("******************");
    }

}
