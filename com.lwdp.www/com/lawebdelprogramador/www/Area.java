
package lawebdelprogramador.www;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jorge Alberto Gomez Gomez, January 13 the 2019, 05:44 PM
 */

public class Area {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option = -1;
        double base = 0, height = 0, radio = 0;

        while (option != 0) {
            option = menu();
            switch (option) {
                case 1:
                    // Area of a square
                    base = requestValue("Enter the base or height: ");
                    System.out.println("\nThe area of the square is:  " + (base * base));
                    break;
                case 2:
                    // Area of a rectangle
                    base = requestValue("Enter the base: ");
                    height = requestValue("Enter the height: ");
                    System.out.println("\nThe area of the rectangle is:  " + (base * height));
                    break;
                case 3:
                    // Area of a circle
                    radio = requestValue("Enter the radio: ");
                    System.out.printf("\nThe area of the circle is %1.2f\n", Math.PI * (Math.pow(radio, 2)));
                    break;
                case 4:
                    // Area of a triangle
                    base = requestValue("Enter the base: ");
                    height = requestValue("Enter the height: ");
                    System.out.printf("\nThe area of the triangle is %1.2f\n", (base * height) / 2);
            }
        }
        input.close();
    }

    private static double requestValue(String text) {
        while (true) {
            try {
                System.out.print(text);
                return input.nextDouble();
            }
            catch (InputMismatchException e) {
                // Control that always the introduced value to be a numerical value
                System.out.println("The value has to be an Integer... ");
                input.nextLine();
            }
        }
    }

    private static int menu() {
        int option = -1;
        System.out.println("\n\n-----------------------------------");
        System.out.println("1--> Area of a square: ");
        System.out.println("2--> Area of a rectangle: ");
        System.out.println("3--> Area of a circle: ");
        System.out.println("4--> Area of a triangle: ");
        System.out.println("0--> Exit: ");
        System.out.println("Select an Option: ");

        while (option < 0) {
            try {
                option = input.nextInt();
            }
            catch (InputMismatchException e) {
                // Control that always the introduced value to be a numerical value
                System.out.println("The value has to be an Integer... ");
                input.nextLine();
                option = -1;
            }
        }
        return option;
    }
}