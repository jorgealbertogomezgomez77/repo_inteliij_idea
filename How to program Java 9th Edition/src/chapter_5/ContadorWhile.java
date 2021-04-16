
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 18 of the 2019, 06:22 PM.
 * Fig. 5.1: ContadorWhile.java.
 * Repetición controlada con contador con la instrucción de repetición while.
 */

public class ContadorWhile {

    public static void main(String[] args) {

        int contador = 1;                         // Declara e inicializa la variable de control.

        while (contador <= 10) {                  // Condición de continuación del ciclo.
            System.out.printf("%d  ", contador);
            ++contador;                           // Incrementa la variable de control en 1.
        }   // Fin del while.
        System.out.println();
    }   // Fin del main
}   // Fin de la clase ContadorWhile.
