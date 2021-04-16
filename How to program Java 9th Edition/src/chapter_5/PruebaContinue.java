
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 23 of the 2019, 00:11 AM.
 * Fig. 5.13: PruebaContinue.java.
 * Instrucción continue para terminar una iteración de una instrucción for.
 */

public class PruebaContinue {

    public static void main(String[] args) {

        for (int cuenta = 1; cuenta <= 10; cuenta++) {      // Itera 10 veces.
            if (cuenta == 5) {                              // Si cuenta es 5.
                continue;                                   // Omite el resto del codigo en el disco
            }
            System.out.printf("%d ", cuenta);
        }   // Fin del for.
        System.out.println("\nUso de continue para omitir imprimir 5");
    }   // Fin del Main
}   // Fin de la clasePruebaContinue
