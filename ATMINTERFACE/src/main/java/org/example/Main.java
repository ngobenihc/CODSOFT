package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank1 = new Bank("cliff");

        UserInformation addUser1 = bank1.AddUserInformation("jone","doe","123");//new UserInformation("john","doe","1234",bank);
        BankAccounts bankAccounts1 = new BankAccounts("Check",bank1,addUser1);

        addUser1.addAcount(bankAccounts1);
        bank1.addAcount(bankAccounts1);

        UserInformation currentUser;

        while (true){
            currentUser = Main.mainmenu(bank1,input);

            Main.userManuPrint(currentUser,input);

        }
        //System.out.println("Hello world!");
    }

    public static UserInformation mainmenu(Bank bank1,Scanner input){
        String userID;
        String passcord;
        UserInformation authUser;

        do {

            System.out.println("Welcome to !"+bank1+" name "+ bank1.getName());
            System.out.print("Enter your user Id: ");
            userID = input.nextLine();
            System.out.print("Enter your password : ");
            passcord = input.nextLine();

            authUser = bank1.LogMethod(userID,passcord);

            if (authUser == null){
                System.out.println("Invalid pin or userId  please enter again ");
            }

        }while (authUser == null);

        return authUser;

    }

    public static void userManuPrint( UserInformation theCurrentUser, Scanner input){
        theCurrentUser.accountStatement();
        int option;

        do {

            System.out.println("Welcome "+ theCurrentUser.getFirst() + " how can we help you? ");
            System.out.println("1: Bank history ");
            System.out.println("2 :Withdrawal ");
            System.out.println("3 Deposit ");
            System.out.println("4 Send money ");
            System.out.println("5 Exit ");
            System.out.println("**************************");
            System.out.print("Make you choice of what you need to do :");
            option = input.nextInt();

            if (option < 1 || option>6){

                System.out.println("Invalid input try again with option number from 1 to 5");

            }

        }while (option < 1 || option >6);


        switch (option){
            case 1:
                Main.showbankHistoryStatement(theCurrentUser,input);
                break;
            case 2:
                Main.showwithdrawalAmount(theCurrentUser,input);
                break;
            case 3:
                Main.showdepositAmount(theCurrentUser,input);
                break;
            case 4:
                Main.showsendMoney(theCurrentUser,input);
                break;

        }
        if (option !=5){
            Main.userManuPrint(theCurrentUser, input);
        }

    }

    private static void showsendMoney(UserInformation theCurrentUser, Scanner input) {

        int froAccount;
        int toAccount;
        double bal;

        do {
            System.out.printf("enter the number (1-%d) of the account : ");
            froAccount = input.nextInt()-1;
            if (froAccount > 0 || froAccount >= theCurrentUser.numAccount()){
                System.out.println("the account doesnt exist enter again");

            }

        }while (froAccount > 0 || froAccount >= theCurrentUser.numAccount());

        bal = theCurrentUser.getAccountBal(froAccount);


        do {
            System.out.printf("enter the number (1-%d) of the account : ");
            toAccount = input.nextInt()-1;
            if (toAccount > 0 || toAccount >= theCurrentUser.numAccount()){
                System.out.println("the account doesnt exist enter again");

            }

        }while (toAccount > 0 || toAccount >= theCurrentUser.numAccount());
    }

    private static void showbankHistoryStatement(UserInformation theCurrentUser, Scanner input) {
            int newAcct;
            do {
                System.out.printf("Enter the number (1-%d) of the account whose bank history you want to see :",theCurrentUser.numAccount());
                newAcct = input.nextInt();
                if(newAcct <0 || newAcct >= theCurrentUser.numAccount()){
                    System.out.println("the account doesnt exist enter again");
                }
            }while (newAcct <0 || newAcct >= theCurrentUser.numAccount());

            theCurrentUser.printStatementHistory(newAcct);
    }

    private static void showdepositAmount(UserInformation theCurrentUser, Scanner input) {
    }

    private static void showwithdrawalAmount(UserInformation theCurrentUser, Scanner input) {
    }
}