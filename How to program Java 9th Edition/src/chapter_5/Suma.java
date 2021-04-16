
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 22 of the 2019, 06:18 PM.
 * Fig. 5.5: Suma.java.
 * Sumar enteros con la instrucción de repetición for.
 */

public class Suma {
    public static void main(String[] args) {
        int total = 0;      // Inicializa el total.
        // Total de los enteros pares del 2 al 20
        for (int numero = 2; numero <= 20; numero += 2) {
            total += numero;
        }
        System.out.printf("L suma es %d\n", total);     // Muestra los resultados.
    }   // Fin del main.
}   // Fin de la clase Suma.
