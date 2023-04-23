package NumberGuessingGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        int random = rand.nextInt(100);
        Scanner scn = new Scanner(System.in);
        int count = 5; // no. of guesses
        int points = 5, guess;

        System.out.println("A number is chosen between 1 to 100. Guess the number within 5 trials.");

        for (int i = 0; i < count; i++) {
            System.out.println("---Enter number---");
            guess = scn.nextInt();
            if (guess == random) {
                System.out.println("Correct guess!");
                System.out.println("Points-> " + points);
                break;
            } else {
                if (guess < random) {
                    System.out.println(guess + " is lower than the secret number...");
                    points--;
                } else {
                    System.out.println(guess + " is higher than the secret number...");
                    points--;
                }
            }
        }
        if(points==0){
            System.out.println("You have exhausted all your trials.");
            System.out.println("The number was " + random);
            System.out.println("Points-> " + points);
        }
    }
}
