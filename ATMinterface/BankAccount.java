package ATMinterface;

import java.util.Scanner;

public class BankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    public BankAccount(String name, String userName, String password, String accountNo) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.accountNo = accountNo;
    }

    public BankAccount() {

    }

    public void register(){
        Scanner scn= new Scanner(System.in);
        System.out.println("Enter your Name: ");
        this.name=scn.nextLine();
        System.out.print("Enter your Username: ");
        this.userName = scn.nextLine();
        System.out.print("Enter your Password: ");
        this.password = scn.nextLine();
        System.out.print("Enter your Account Number: ");
        this.accountNo = scn.nextLine();
        System.out.println("Registration completed..kindly login...");
    }

    public boolean login(){
        boolean isLogin=false;
        Scanner scn= new Scanner(System.in);
        while(!isLogin){
            System.out.println("Enter your Username: ");
            String username= scn.nextLine();
            if(username.equals(userName)){
                while(!isLogin){
                    System.out.println("Enter your Password: ");
                    String pass= scn.nextLine();
                    if(pass.equals(password)){
                        System.out.println("Login successful!");
                        isLogin=true;
                    }
                    else {
                        System.out.println("Incorrect Password");
                    }
                }
            }
            else{
                System.out.println("Username not found...");
            }
        }
        return isLogin;
    }

    public void withdraw(){
        System.out.print("Enter amount to withdraw -> ");
        Scanner scn = new Scanner(System.in);
        float amt= scn.nextFloat();
        if(balance>=amt){
            transactions++;
            balance-=amt;
            System.out.println("Withdraw successful!");
            String s= amt+" Rs withdrawn\n";
            transactionHistory = transactionHistory.concat(s);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }

    public void deposit(){
        System.out.println("Enter amount to deposit -> ");
        Scanner scn=new Scanner(System.in);
        float amt= scn.nextFloat();
        if (amt<= 100000f) {
            transactions++;
            balance+=amt;
            System.out.println("Successfully Deposited");
            String s= amt+" Rs deposited\n";
            transactionHistory = transactionHistory.concat(s);
        }
        else {
            System.out.println("Can't deposit...Limit is 100000.00");
        }
    }

    public void transfer(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Recipient's Name: ");
        String recipient = scn.nextLine();
        System.out.print("Enter amount to transfer: ");
        float amt = scn.nextFloat();
        if ( balance>=amt ) {
            if (amt<=10000f) {
                transactions++;
                balance-= amt;
                System.out.println("Successfully Transferred to " + recipient);
                String str= amt + " Rs transferred to " + recipient + "\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else {
                System.out.println("Sorry...Limit is 10000.00");
            }
        }
        else {
            System.out.println("Insufficient Balance");
        }
    }

    public void checkBalance() {
        System.out.println("Your account balance is: " + balance + " Rs");
    }

    public void TransactionHistory() {
        if (transactions == 0 ) {
            System.out.println("\nEmpty");
        }
        else {
            System.out.println("\n" + transactionHistory);
        }
    }
}
