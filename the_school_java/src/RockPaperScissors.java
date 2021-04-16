import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("The one player chose rock, paper, or scissors? ");
        String onePlayer = input.next();
        System.out.println("The two player chose rock, paper, or scissors? ");
        String twoPlayer = input.next();

        // One method
        if (onePlayer.equals("Rock")) {
            if (twoPlayer.equals("Scissors")) {
                System.out.println("Player one won");
            }
            else if (twoPlayer.equals("Paper")) {
                System.out.println("Player two won");
            }
            else {
                System.out.println("Tie!");
            }
        }
        else if (onePlayer.equals("Paper")) {
            if (twoPlayer.equals("Scissors")) {
                System.out.println("Player two won");
            }
            else if (twoPlayer.equals("Rock")) {
                System.out.println("Player one won");
            }
            else {
                System.out.println("Tie");
            }
        }
        else {
            if (twoPlayer.equals("Scissors")) {
                System.out.println("Tie");
            }
            else if (twoPlayer.equals("Paper")) {
                System.out.println("Player one won");
            }
            else {
                System.out.println("Player two won");
            }
        }

        // Second method
        if ((onePlayer.equals("Rock") & twoPlayer.equals("Scissors")) ||
                (onePlayer.equals("Scissors") & twoPlayer.equals("Paper")) ||
                (onePlayer.equals("Paper") & twoPlayer.equals("Rock"))) {
            System.out.println("Player one won");
        }
        else if ((onePlayer.equals("Rock") & twoPlayer.equals("Rock")) ||
                (onePlayer.equals("Scissors") & twoPlayer.equals("Scissors")) ||
                (onePlayer.equals("Paper") & twoPlayer.equals("Paper"))) {
            System.out.println("Tie");
        }
        else {
            System.out.println("Player one won");
        }
    }
}
