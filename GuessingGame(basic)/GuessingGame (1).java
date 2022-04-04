
/**
 * GuessingGame -- first part of assignment 2 in 2ip90
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   20.09.2021
 */

import java.util.*; // for Scanner and Random
import java.util.Locale;

class GuessingGame {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    Random randomGenerator;
    String choice; // The choice the user has to make
    int code; // The number which has to be guessed
    long seed; // The arbitrary number (in case the choice is "no")
    int numofguesses = 0; // The number of guesses
    int[] guesses = new int[7]; // An array in which the guesses are stored
    char[][] graph = { { '.', '|' }, { 'X', 'X' } };

    void run() {
        // TODO: Implementation
        System.out.println("Do you want to enter the secret code yourself?"); // The required output

        choice = scanner.next(); // Reading the user's choice

        // The "if" loop that decides which value will take "code" (the one given by the
        // user or assigned randomly)
        if (choice.equals("yes")) {
            System.out.println("Secretly type the code");
            code = scanner.nextInt(); // If the answer is "yes", then "code" becomes the given value
        } else if (choice.equals("no")) {
            System.out.println("Type an arbitrary number");
            seed = scanner.nextLong();
            randomGenerator = new Random(seed);
            code = randomGenerator.nextInt(100); // If the answer is "no", "code" has a random value between 0 and 99
        }

        System.out.println("Start guessing!"); // The guessing can start now

        // The process by which the computer tells the user "higher" or "lowe",
        // depending on the input.
        while (numofguesses < 7) { // The maximum number of guesses is 7
            guesses[numofguesses] = scanner.nextInt();
            if (guesses[numofguesses] == code) {
                System.out.println("Good guess! You won.");
                numofguesses++;
                break; // In this case the loop stops running, because the user found out which is the
                       // number
            } else {
                System.out.println((guesses[numofguesses] < code) ? "higher" : "lower");
            }
            numofguesses++;
        }

        // This is the case when the maximum number of attempts is reached
        if (numofguesses == 7 && guesses[6] != code) {
            System.out.println("No more guesses, you lost.");
        }

        System.out.println(numofguesses + " guesses:"); // Printing the number of guesses

        // Here is the history of the attempts, using "for" loops
        for (int i = 0; i < numofguesses; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(graph[(j == guesses[i]) ? 1 : 0][(j == code) ? 1 : 0]);
            }
            System.out.print("\n"); // A new line is started each time the loop is traversed
        }

        // END TODO
    }

    public static void main(String[] args) {
        (new GuessingGame()).run();
    }
}