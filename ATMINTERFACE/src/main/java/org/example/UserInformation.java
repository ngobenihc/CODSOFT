package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class UserInformation {
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private byte pinNumber[];
    private String userIdNum;
    private ArrayList<BankAccounts>accountsTypes;

    public String getFirst() {
        return name;
    }

    public UserInformation(String name, String surname, String pin, Bank bank) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
      try {
          MessageDigest pn = MessageDigest.getInstance("MD5");
          this.pinNumber = pn.digest(pin.getBytes());
      } catch (NoSuchAlgorithmException e){
          System.err.println("err input");
          e.printStackTrace();
          System.exit(1);
      }
      this.userIdNum = bank.getUserIdNum();

      this.accountsTypes = new ArrayList<BankAccounts>();

      System.out.println("the user is "+ name + " "+ surname + " "+ userIdNum);
//
    }
    public void addAcount(BankAccounts bankAccounts){
        this.accountsTypes.add(bankAccounts);
    }

    public String getUSERID() {
        return userIdNum;
    }

    public boolean PinValidation(String pin){

        try {
            MessageDigest pn = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(pn.digest(pin.getBytes()), this.pinNumber);
        } catch (NoSuchAlgorithmException e){
            System.err.println("err input");
            e.printStackTrace();
            System.exit(1);
        }

        return false;
    }

    public void accountStatement(){
        System.out.println("My bank accounts "+name);
        for(int i =0; i< this.accountsTypes.size(); i++){
            System.out.printf("%d %a \n ",i, this.accountsTypes.get(i).getLinestatment());
        }
        System.out.println();
    }

    public int numAccount(){
        return this.accountsTypes.size();
    }

    public void printStatementHistory(int index){
        this.accountsTypes.get(index).printAcountHistory();
    }

    public double getAccountBal(int index){
        return this.accountsTypes.get(index).getBalance();
    }
}
