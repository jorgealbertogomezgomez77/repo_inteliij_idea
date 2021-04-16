
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 22 of the 2019, 07:00 PM.
 * Fig. 5.7: PruebaDoWhile.java.
 * La instrucción de repetición do...while.
 */

public class PruebaDoWhile {

    public static void main(String[] args) {

        int contador = 1;       // Inicializa el contador.

        do {
            System.out.printf("%d ", contador);
            ++contador;
        }
        while (contador <= 10);         // Fin de do...while
        System.out.println();           // Imprime una nueva línea.
    }   // Fin del main.
}   // Fin de la clase PruebaDoWhile.
