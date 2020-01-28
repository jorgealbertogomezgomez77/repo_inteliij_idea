package lawebdelprogramador;

import java.util.Arrays;

public class proof {

    public static int sequence[] = {10, 1, 2, 3, 4, 5};

    public static void main(String[] args) {
        System.out.println(resultado());
    }

    public static boolean resultado() {
        for (int i = 0; i < sequence.length - 2; i++) {
            if (sequence[i] < sequence[i + 1]) {
                continue;
            }
            else if (sequence[i] > sequence[i + 1]) {
                i += 1;
            }
            return true;
        }
        return false;
    }
}
