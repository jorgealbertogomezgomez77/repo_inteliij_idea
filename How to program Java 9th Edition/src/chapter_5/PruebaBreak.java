
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 23 of the 2019, 00:03 AM.
 * Fig. 5.12: PruebaBreak.java.
 * La instrucción break para salir de una instrucción for.
 */

public class PruebaBreak {

    public static void main(String[] args) {

        int cuenta;         // La variable de control también se usa cuando termina el ciclo.

        for (cuenta = 1; cuenta <= 10; cuenta++) {      // Itera 10 veces.
            if (cuenta == 5) {                          // Si cuenta es 5.
                break;                                  // Termina el ciclo.
            }
            System.out.printf("%d ", cuenta);
        }   // Fin del for.
        System.out.printf("\nSalio del ciclo en cuenta = %d\n", cuenta);
    }   // Fin del main.
}   // Fin de la clase PruebaBreak.
