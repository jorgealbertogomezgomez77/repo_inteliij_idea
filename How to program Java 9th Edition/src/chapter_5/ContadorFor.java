
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 18 of the 2019, 06:22 PM.
 * Fig. 5.2: ContadorFor.java.
 * Repetición controlada con contador con la instrucción de repetición for.
 */

public class ContadorFor {

    public static void main(String[] args) {

        // El encabezado de la instruccion for incluye la inicialización ,
        // la condición de continuación de ciclo y el incremento.
        for (int contador = 1; contador <= 10; contador++) {
            System.out.printf("%d  ", contador);
        }
        System.out.println();   // Imprime una nueva linea.
    }   // Fin del main.
}   // Fin de la clase ContadorFor.
