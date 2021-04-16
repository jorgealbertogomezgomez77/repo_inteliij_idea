
public class cuestionary_02 {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        if(x && y) {
            System.out.println("a");
        } else if (x || y) {
            System.out.println("b");
        } else if (!x) {
            System.out.println("c");
        } else {
            System.out.println("d");
        }
    }
}
