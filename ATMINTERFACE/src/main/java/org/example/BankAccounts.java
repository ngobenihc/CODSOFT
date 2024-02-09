package org.example;

import java.util.ArrayList;


public class BankAccounts {

    private String name;
    private String accountIdNum;
    private double balance;
    private UserInformation informationHolder;
    private ArrayList<BankTransaction> transactionsTypes;

    public BankAccounts(String name,Bank bank,UserInformation informationHolder) {
        this.name = name;
        this.informationHolder = informationHolder;

        this.accountIdNum = bank.accountIdNum();
        this.transactionsTypes = new ArrayList<BankTransaction>();



    }
    public String getACCOUNTID() {
        return accountIdNum;
    }


    public String getLinestatment(){
        double balance = this.getBalance();

        if (balance >=0){
            return String.format("%s : R%.02f : %s",this.accountIdNum, balance,this.name);
        }else {

            return String.format("%s : R(%.02f) : %s",this.accountIdNum, balance,this.name);

        }
    }

    public double getBalance(){
        double bal = 0.0;
        for (BankTransaction i : this.transactionsTypes){
            bal  +=  i.getAccount();
        }
        return bal;
    }

    public void printAcountHistory(){
        System.out.printf("show account history %s",this.accountIdNum);

        for (int x = this.transactionsTypes.size()-1; x >= 0; x--){
            System.out.printf(this.transactionsTypes.get(x).getLineSammary());

        }
        System.out.println("");
    }
}
