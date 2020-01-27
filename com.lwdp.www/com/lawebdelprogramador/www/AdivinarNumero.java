
package lawebdelprogramador.www;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jorge Alberto Gomez Gomez, January 13 the 2019, 04:04 PM
 */

public class AdivinarNumero {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Game to guess a number");
        System.out.println("----------------------");

        // Get a random value between 1 and 100
        int number = (int) (Math.random() * 100);

        int input = -1;
        int count = 0;

        // Loop until the user guesses the number
        do {
            // Get a new value
            input = getValue();
            if (input > number) {
                System.out.println("The number is lower");
            }
            else if (input < number) {
                System.out.println("The number is upper");
            }
            count ++;
        }
        while (input != number); {
            System.out.println("You have guessed the number in " + count + " attempts.");
        }
    }

    public static int getValue() {
        int value = 0;
        // Start a infinite loop
        while (true) {
            try {
                System.out.println("Enter the number: ");
                value = input.nextInt();

                //Check if the number introduced is between 0 and 100
                if (value < 0 || value > 100) {
                    System.out.println("The introduced number has to be between 0 and 100");
                }
                else {
                    // We left the loop
                    break;
                }
            }
            catch (InputMismatchException e) {
                // We control that you are always introduced by a numerical value
                System.out.println("The introduced value has to be an Integer...");
                input.nextLine();
            }
        }
        return value;
    }
}
