/**
 * GuessingGameAdvanced -- second part of assignment 2 in 2ip90
 * @author Toma Andrei Sacuiu
 * @id     1681591
 * @author Bianca Neagoe
 * @id     1708287
 * @date   20.09.2021
 */

import java.util.Scanner;
import java.util.Locale;

class GuessingGameAdvanced {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    String choice; //the users' input
    int guess; 
    int count = 0; //counts the number of attemps
    int lowestvalue;
    int highestvalue;
    String reply; //the users' response

    void run() {
        // TODO: Implementation

        System.out.println("Think of a secret number not smaller than 0 and not greater than 1000. Type 'go' when you have one.");

        choice = scanner.next();

        if(choice.equals("go")){

            guess = 1000/2; //the guess is initially the middle between 0 and 1000
            lowestvalue = 0;
            highestvalue = 1000;

            //the binary search algorithm
            while(count <= 10){

                if(count == 10){
                    System.out.println("I give up.");
                    break;
                }

                System.out.println(guess);
                reply = scanner.next();

                if((reply.equals("guessed")) || (reply.equals("g"))){
                    break;
                }
                if(reply.equals("lower") || reply.equals("l")){
                    highestvalue = guess;
                }
                if(reply.equals("higher") || reply.equals("h")){
                    lowestvalue = guess;
                }

                guess = (lowestvalue + highestvalue)/2;
                count++;

            }

        }
        
        // END TODO
    }

    public static void main(String[] args) {
        (new GuessingGameAdvanced()).run();
    }
}
