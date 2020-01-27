
package lawebdelprogramador.www;

/**
 * @author Jorge Alberto Gomez Gomez, January 13 the 2019, 05:11 PM
 */

public class Alphabet_lower {
    public static void main(String[] args) {
        int x, y, s;
        char a = 0;
        String q = "";
        String c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(" Of \n Mayusculas: \n A B C D E F G H I J K L M N O P Q R S T U V W X Y Z \n to \n minusculas: ");
        for (int z = 0; z < c.length(); z++) {
            y = c.charAt(z);
            x = (int) (y);
            s = x + 32;
            a = (char) s;
            q = q + " " + a;
        }
        System.out.println(q);
    }
}
