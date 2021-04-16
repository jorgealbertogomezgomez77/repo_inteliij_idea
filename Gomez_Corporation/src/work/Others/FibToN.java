
package work.Others;

import java.util.Scanner;

/**
 * @author Jorge Alberto Gomez Gomez, January 07 of the 2019, 09:38 PM
 * Fibonacci sequence, and characterized by the fact that every number
 * after the first two is the sum of the two proceding ones.
 * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21,...
 * Source for the explanation: https://en.wikipedia.org/wiki/Fibonacci_number
 */

public class FibToN {
    public static void main(String[] args) {
        // Take input
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        // Print all Fibonacci numbers that are smaller than your given input N
        int first = 0, second = 1;
        scn.close();
        while (first <= N) {
            // Print first fibo 0 then add second fibo into it while updating second as well
            System.out.println(first);
            int next = first + second;
            first = second;
            second = next;
        }
    }
}
