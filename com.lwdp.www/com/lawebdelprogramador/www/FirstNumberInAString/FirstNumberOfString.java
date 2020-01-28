
package lawebdelprogramador.www.FirstNumberInAString;

/**
 * @author Ing. Jorge Alberto Gomez Gomez, January 30 of the 2019, 07:33 PM
 * @mail jorgealbertogomezgomez77@gmail.com
 */

public class FirstNumberOfString {

    public static void main(String[] args) {

        System.out.println(getFirstNumberFromString("La casa numero 23 es muy grande"));
    }

    public static int getFirstNumberFromString(String str) {
        int num = (int)Float.NaN;
        int i = 0;
        int j = 0;
        int p = 0;
        int p2 = 0;

        String aux = "";
        String aux2 = "";

        while (j < str.length()) {
            aux2 = "" + str.charAt(j);
            if (isNumeric(aux2)) {
                if (j - 1 >= 0) {
                    aux2 = "" + str.charAt(j - 1);
                    if (aux2.equals("-")) {
                        j = j - 1;
                    }
                }
                p = j;
                j = str.length();
            }
            j++;
        }
        i = p;
        while (i < str.length()) {
            aux = str.substring(p, i + 1);
            if (isNumeric(aux)) {
                num = Integer.parseInt(aux);
            }
            i++;
        }
        return num;
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
