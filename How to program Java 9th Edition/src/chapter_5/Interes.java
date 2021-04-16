
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 22 of the 2019, 06:31 PM.
 * Fig. 5.6: Interes.java.
 * Calculo de interés compuesto con la instrucción de repetición for.
 */

public class Interes {

    public static void main(String[] args) {

        double monto;                   // Monto depositado al final de cada año.
        double principal = 1000.0;      // Monto principal antes de los intereses.
        double tasa = 0.05;             // Tasa de interés.

        // Muestra los encabezados.
        System.out.printf("%s%20s\n", "Anio", "Monto en deposito" );

        // Calcula el monto en depósito para cada uno de los años.
        for (int anio = 1; anio <= 100; anio++) {
            // Calcula el nuevo monto para el año especificado.
            monto = principal * Math.pow(1.0 + tasa, anio);

            // Muestra el año y el monto.
            System.out.printf("%4d%, 20.2f\n", anio, monto);
        }   // Fin del for.
    }   // Fin del main.
}   // Fin de la clase Interes.
