
package chpater_4;

/**
 * @author Jorge Alberto Gomez Gomez, January 18 of the 2019, 11:23 PM.
 * Fig. 4.15: Incremento.java.
 * Operadores de preincremento y postincremento.
 */

public class Incremento {

    public static void main(String[] args) {
        int c;

         // Demuestra el operador de postincremento.
        c = 5;                      // Asigna 5 a c.
        System.out.println(c);      // Imprime 5.
        System.out.println(c++);    // Imprime 5, despues postincrementa.
        System.out.println(c);      // Imprime 6.
        System.out.println();       // Suma las calificaciones.
        // Demuestra el operador de preincremento.
        c = 5;                      // Asigna 5 a c
        System.out.println(c);      // Imprime 5.
        System.out.println(++c);    // Preincrementa y después imprime 6.
        System.out.println(c);      // Imprime 6.
    }   // Fin del main.
}   // Fin de la clase incremento.
