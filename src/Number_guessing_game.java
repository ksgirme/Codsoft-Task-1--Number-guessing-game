import java.util.Random;
import java.util.Scanner;

public class Number_guessing_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int maxScore = 100;
        int rounds = 0;
        int totalScore = 0;


        System.out.println("*******WELCOME TO NUMBER GUESSING GAME!*******");
        System.out.println("Rules and regulations of the game : " +'\n'+
                "     1. You have ten attempts to win the game" +'\n'+
                "     2. Each uncorrect attempt will reduce score by 10 of total score of 100");
        System.out.println(" ");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("\nRound " + (rounds + 1) + " - Guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    int roundScore = maxScore - (attempts - 1) * (maxScore / maxAttempts);
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    roundWon = true;
                    totalScore += roundScore;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!roundWon) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber);
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over! You played " + rounds + " rounds and your total score is " + totalScore + " out of " + (rounds * maxScore));
        scanner.close();
    }
}
