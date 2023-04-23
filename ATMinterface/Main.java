package ATMinterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        System.out.println("-------------WELCOME TO ATM INTERFACE-------------");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice -> ");
        int choice = scn.nextInt();
        try {
            if (choice == 1) {
                BankAccount bankAccount = new BankAccount();
                bankAccount.register();
                while (true) {
                    System.out.println("\n1.Login \n2.Exit");
                    System.out.print("Enter Your Choice -> ");
                    int ch = scn.nextInt();
                    if (ch == 1) {
                        if (bankAccount.login()) {
                            System.out.println("\nWELCOME BACK " + bankAccount.name + "\n");
                            boolean isFinished = false;
                            while (!isFinished) {
                                System.out.println("1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                                System.out.print("Enter Your Choice -> ");
                                int c = scn.nextInt();
                                switch (c) {
                                    case 1 -> bankAccount.withdraw();
                                    case 2 -> bankAccount.deposit();
                                    case 3 -> bankAccount.transfer();
                                    case 4 -> bankAccount.checkBalance();
                                    case 5 -> bankAccount.TransactionHistory();
                                    case 6 -> isFinished = true;
                                    default -> System.out.println("\nInvalid Choice");
                                }
                            }
                        }
                    } else {
                        System.exit(0);
                    }
                }
            } else {
                System.exit(0);
            }
        }catch (Exception e){
            e.getMessage();
        }

    }
}
