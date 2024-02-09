package org.example;

import java.util.Date;

public class BankTransaction {

    private double amount;
    private Date timeStamp;
    private String memo;
    private BankAccounts accountsHolder;


    public BankTransaction(double amount, BankAccounts accountsHolder) {
        this.amount = amount;
        this.accountsHolder = accountsHolder;
        timeStamp = new Date();
        this.memo ="";
    }

    public BankTransaction(double amount, String memo, BankAccounts accountsHolder) {
        this(amount,accountsHolder);
        this.memo = memo;
        timeStamp = new Date();
    }

    public double getAccount(){
        return this.amount;
    }

    public String getLineSammary(){

        if (this.amount >=0){
            return String.format("%s %.02f %s",this.timeStamp.toString(),this.amount,this.memo);
        }else {
          return   String.format("%s (%.02f) %s",this.timeStamp.toString(),this.amount,this.memo);
        }

    }
}

