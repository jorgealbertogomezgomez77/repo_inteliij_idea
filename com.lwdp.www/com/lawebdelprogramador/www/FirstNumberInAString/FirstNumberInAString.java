
package lawebdelprogramador.www.FirstNumberInAString;

/**
 * @author Ing. Jorge Alberto Gomez Gomez, January 31 of the 2019, 03:13 PM
 * @mail jorgealbertogomezgomez77@gmail.com
 */

public class FirstNumberInAString {

    public static void main(String[] args) {
        System.out.println(firstNumber("La casa 23 es muy grande."));
    }

    public static int firstNumber(String str) {
        int number = (int)Float.NaN;
        //String[] arr = new String[0];
        //arr = str.split(" ");
        String array[] = str.split(" ");

        for (int i = 0; i < array.length; i++) {
            if (isNumeric(array[i])) {
                number = Integer.parseInt(array[i]);
            }
        }

        return number;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
