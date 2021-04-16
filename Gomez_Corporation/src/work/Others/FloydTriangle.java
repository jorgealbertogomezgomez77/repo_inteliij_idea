
package work.Others;

import java.util.Scanner;

/**
 * @author Jorge Alberto Gomez Gomez, January 07 of the 2019, 09:50 PM
 */

public class FloydTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows which you want in your Floyd Triangle: ");
        int r = sc.nextInt(), n = 0;
        sc.close();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(++n + " ");
            }
            System.out.println();
        }
    }
}
