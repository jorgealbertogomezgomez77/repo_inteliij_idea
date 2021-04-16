
package work.Others;

import java.util.Scanner;

/**
 * @author Jorge Alberto Gomez Gomez, January 06 of the 2019
 * @author Kyler Smith, 2017
 * Implementation of a character count.
 * (Slow, could be improved upon, effectively 0(n).
 */

public class CountChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Entry your text: ");
        String str = input.nextLine();
        input.close();
        System.out.println("There are " + CountCharacters(str) + " characters.");
    }
    /**
     * @param str: String to count the characters
     * @return int: Number of characters in the passed string
     */
    private static int CountCharacters(String str) {
        int count = 0;
        if (str == "" || str == null) { // Exceptions
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
