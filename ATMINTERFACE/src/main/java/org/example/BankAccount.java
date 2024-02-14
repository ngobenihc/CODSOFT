package org.example;

import java.util.ArrayList;

public class BankAccount {

    private String name;
    private String uuid;
    private UserInformation holder;
    private ArrayList<BankTransaction> transactions;

    public BankAccount(String name, UserInformation holder,BankMain theBank) {
        this.name = name;
        this.holder = holder;

        this.uuid = theBank.getNewAccountUUID();
        this.transactions = new ArrayList<BankTransaction>();


    }

    public String getUUID() {
        return this.uuid;
    }

    public String getSummaryLine() {
        double balance = this.getBalance();

        if (balance >=0){
            return String.format("%s : R%.02f : %s",this.uuid, balance,this.name);
        }else {

            return String.format("%s : R(%.02f) : %s",this.uuid, balance,this.name);

        }
    }

    public double getBalance(){
        double balance = 0.0;
        for (BankTransaction i : this.transactions){
            balance  +=  i.getAmount();
        }
        return balance;
    }

    public void printTransHistory() {

        System.out.printf("\nTransaction history for account %s ",this.uuid);

        for (int x = this.transactions.size()-1; x >= 0; x--){
            System.out.println(this.transactions.get(x).getSummaryLine());

        }
        System.out.println();
    }

    public void addTransaction(double amount, String memo) {

        BankTransaction newTransaction = new BankTransaction(amount,memo,this);
        this.transactions.add(newTransaction);

    }
}
