
package work.Others;

import java.util.Scanner;

/**
 * A utility to check if a given number is armstrong or not. Armstrong number is
 * a number that is equal to the sum of cubes of its digits for example 0, 1, 153,
 * 370, 371, 407 etc. For example 153 = 1^3 + 5^3 + 3^3
 *
 * @author Jorge Alberto Gomez Gomez
 * @author Mani Manasa Mylavarapu
 */

public class Armstrong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number: ");
        int n = scan.nextInt();
        boolean isArmstrong = checkIfANumberIsArmstrongOrNot(n);
        if (isArmstrong) {
            System.out.println("The number is Armstrong.");
        }
        else {
            System.out.println("The number is not Armstrong.");
        }
    }

    /**
     * Checks whether a given number is an armstrong number or not. Armstrong
     * number is a number that is equal to the sum of cubes of its digits for
     * example 0, 1, 153, 370, 371, 407 etc.
     *
     * @param number
     * @return boolean
     */
    public static boolean checkIfANumberIsArmstrongOrNot(int number) {
        int remainder, sum = 0, temp = 0;
        temp = number;
        while (number > 0) {
            remainder = number % 10;
            sum = sum + (remainder * remainder * remainder);
            number = number / 10;
        }
        if (sum == temp) {
            return true;
        }
        else {
            return false;
        }
    }
}
