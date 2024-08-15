import java.security.SecureRandom;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        introduce();

        // randomNumbers object will produce secure random numbers
        SecureRandom randomNumbers = new SecureRandom();
        int randomValue = 1 + randomNumbers.nextInt(100);
        Scanner input = new Scanner(System.in);

        System.out.println("I'm thinking of a number between 1 and 100...");
        System.out.println("Your guess? ");
        int guess = input.nextInt();
        int count = 1;
        int games = 0;
        boolean correctAnswer = false;
        int tgame = 0;
        int tguess = 0;
        int bgame = count;


        while (!correctAnswer) {
            if (guess < randomValue) {
                System.out.println("It's too low. Try again: ");
                guess = input.nextInt(); // Prompt for a new guess
                count++;
            } else if (guess > randomValue) {
                System.out.println("It's too high. Try again: ");
                guess = input.nextInt(); // Prompt for a new guess
                count++;
            } else {
                correctAnswer = true;
                System.out.println("You got it right in " + count + " guesses");
                games ++;
                tgame += games;
                tguess += count;
                if (count == 0){
                    bgame = count;
                } else if (count < bgame){
                    bgame = count;
                }

                System.out.println("Would you like to try again(y/n):");
                char restart = input.next().charAt(0);
                if (restart == 'y') {
                    count = 1;  // Reset guess counter
                    correctAnswer = false;
                    System.out.println("I'm thinking of a number between 1 and 100...");
                    System.out.println("Your guess? ");// Prompt for a new guess
                    guess = input.nextInt();
                    count++;

                } else {
                    System.out.println("Overall Guess:");
                    System.out.println("Total Games: " + tgame );
                    System.out.println("Total Guess:" + tguess);
                    System.out.println("Guess per game:" + (tgame / tguess));
                    System.out.println("Best Game:" + bgame);
                }
            }

        }

    }

    public static void introduce() {
        System.out.println("This program allows you to play a guessing game.\n" +
                "I will think of a number between 1 and\n" +
                "100 and will allow you to guess until\n" +
                "you get it. For each guess, I will tell you\n" +
                "whether the right answer is higher or lower\n" +
                "than your guess.\n");

    }
}
