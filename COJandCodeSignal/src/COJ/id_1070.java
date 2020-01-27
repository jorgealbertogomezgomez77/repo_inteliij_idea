package COJ;

import java.util.Scanner;

public class id_1070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        int cuadrados;
        int rectangulos;
        cuadrados = ((2 * (numero*numero*numero) + 3 * (numero*numero) + numero) / 6);
        rectangulos = (((numero*numero*numero*numero) + 2 * (numero*numero*numero) + (numero*numero)) / 4);
        System.out.println(cuadrados + " " + rectangulos);
    }
}
