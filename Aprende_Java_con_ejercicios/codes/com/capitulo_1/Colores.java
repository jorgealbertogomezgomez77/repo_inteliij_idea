
package com.capitulo_1;

/**
 *Colored text.
 *
 * Show many words in the corresponding color.
 *
 * @author Jorge Alberto Gomez Gomez.
 *
 * December, 21 del 2018, 06:40 pm.
 */

public class Colores {
    public static void main(String[] args) {
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String naranja = "\033[33m";
        String azul = "\033[34m";
        String morado = "\033[35m";
        String blanco = "\033[37m";

        System.out.println(naranja + " mandarina " + verde + " hierba ");
        System.out.println(naranja + " saltamontes " + rojo + " tomate ");
        System.out.println(blanco + " sábanas " + azul + " cielo ");
        System.out.println(morado + " nazareno " + azul + " mar ");
    }
}
