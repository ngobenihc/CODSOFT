package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<UserInformation> userInformationsList;
    private ArrayList<BankAccounts>accountsTypes;

    public String getName() {
        return name;
    }

    public Bank(String name) {
        this.name = name;
        this.accountsTypes =new ArrayList<BankAccounts>();
        this.userInformationsList = new ArrayList<UserInformation>();
    }

    public  String getUserIdNum(){
        String userId;
        Random random = new Random();
        int number;
        number = (int) (Math.random()*10);
        int len = 4;
        boolean isUnique;

        do {
            userId ="";

            for (int i =0;i <=len;i++){
                userId = userId + ((Integer)random.nextInt(10)).toString();
            }

            isUnique = false;
            for(UserInformation i :this.userInformationsList){

                if (userId.compareTo(i.getUSERID()) == 0);

                isUnique=true;
                break;

            }

        }while (isUnique);

        return userId;

    }

    public String accountIdNum(){
        String userId;
        Random random = new Random();
        int number;
        number = (int) (Math.random()*10);
        int len = 5;
        boolean isUnique;

        do {
            userId ="";

            for (int i =0;i <=len;i++){
                userId += ((Integer)random.nextInt(10)).toString();
            }

            isUnique = false;
            for(BankAccounts i :this.accountsTypes){

                if (userId.compareTo(i.getACCOUNTID()) == 0);

                isUnique=true;
                break;

            }

        }while (isUnique);

        return userId;
    }
   public void addAcount(BankAccounts bankAccounts){
       this.accountsTypes.add(bankAccounts);
   }

    public UserInformation AddUserInformation(String name, String surname, String pin){
        UserInformation newUser = new UserInformation (name, surname, pin,this);
        this.userInformationsList.add(newUser);

        BankAccounts newbankAccounts = new BankAccounts("saving",this,newUser);
        newUser.addAcount(newbankAccounts);
        this.accountsTypes.add(newbankAccounts);

        return newUser;
    }

    public UserInformation LogMethod(String IdLog, String pin){
        for (UserInformation x: this.userInformationsList){
            if (x.getUSERID().compareTo(IdLog) ==0 && x.PinValidation(pin)){

                return x;

            }
        }
        return null;
    }
}

