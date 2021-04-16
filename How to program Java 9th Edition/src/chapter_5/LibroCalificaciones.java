
package chapter_5;

import java.util.Scanner;               // El programa utiliza la clase Scanner.

/**
 * @author Jorge Alberto Gomez Gomez, January 22 of the 2019, 07:12 PM.
 * Fig. 5.9: LibroCalificaciones.java.
 * La clase LibroCalificaciones usa la instruccion switch para contar las calificaciones de leteras.
 */

public class LibroCalificaciones {

    private String nombreDelCurso;      // Nombre del curso que representa este LibroCalificaciones.

    // Las variables de instancia int se inicializan en 0 de manera predeterminada.
    private int total;                  // Suma de las calificaciones.
    private int contadorCalif;          // Número de calificaciones introducidas.
    private int aCuenta;                // Cuenta de calificaciones A.
    private int bCuenta;                // Cuenta de calificaciones B.
    private int cCuenta;                // Cuenta de calificaciones C.
    private int dCuenta;                // Cuenta de calificaciones D.
    private int fCuenta;                // Cuenta de calificaciones F.

    // El constructor inicializa nombreDelCurso.
    public LibroCalificaciones(String nombre) {
        nombreDelCurso = nombre;        // Inicializa nombreDelCurso.
    }   // Fin del constructor.

    // Método para establecer el nombre del curso.
    public void establecerNombreDelCurso(String nombre) {
        nombreDelCurso = nombre;        // Almacena el nombre del curso.
    }   // Fin del método establecerNombreDelCurso.

    // Método para obtener el nombre del curso.
    public String obtenerNombreDelCurso() {
        return nombreDelCurso;
    }   // Fin del método obtenerNombreDelCurso.

    // Muestra un mensaje de bienvenida al usuario de LibroCalificaciones.
    public void mostrarMensaje() {
        // obtenerNombreDelCurso obtiene el nombre del curso.
        System.out.printf("Bienvenido al Libro de Calificaciones para \n%s!\n\n", obtenerNombreDelCurso());
    }   // Fin del método mostrarMensaje.

    // Introduce un número aleatorio de calificaciones del usuario.
    public void introducirCalif() {

        Scanner entrada = new Scanner(System.in);

        int calificacion;               // Calificacion introducida por el usuario.

        System.out.printf("%s\n%s\n    %s\n    %s\n",
                "Escriba las calificaciones enteras en el rango de 0 a 100.",
                "Escriba el indicador de fin de archivo para terminar la entrada:",
                "En UNIX/Linux/Mac OS X escriba <Ctrl> d y después oprima Intro",
                "En Windows escriba <Crtl> z y después oprima Intro");

        // Itera hasta que el usuario introduzca el indicador de fin de archivo
        while (entrada.hasNext()) {
            calificacion = entrada.nextInt();       // Lee calificación.
            total += calificacion;                  // Suma calificacion a total.
            ++contadorCalif;                        // Incrementa el numero de calificaciones.

            // Llama al método para incrementar el contador apropiado.
            incrementarContadorCalifLetra(calificacion);
        }   // Fin del while.
    }   // Fin del método introducirCalif

    // Suma 1 al contador apropiado para la calificación especificada.
    private void incrementarContadorCalifLetra(int calificacion) {
        // Determina cuál calificación se introdujo.
        switch (calificacion / 10) {
            case 9:     // Calificación está entre 90 y 100 inclusive.
            case 10:
                ++aCuenta;      // Incrementa aCuenta.
                break;          // Necesaria para salir del switch.
            case 8:             // Calificación está entre 80 y 89.
                ++bCuenta;      // Incrementa bCuenta.
                break;          // Sale del switch.
            case 7:             // Calificación está entre 70 y 79.
                ++cCuenta;      // Incrementa cCuenta.
                break;          // Sale del switch.
            case 6:             // Calificación está entre 60 y 69.
                ++dCuenta;      // Incrementa dCuenta.
                break;          // Sale del switch.
            default:             // Calificación es menor que 60.
                ++fCuenta;      // Incrementa fCuenta.
                break;          // Opcional; de todas formas sale del switch.
        }   // Fin del switch.
    }   // Fin del método incrementarContadorCalifLetra.

    // Muestra un reporte con base en las calificaciones introducidas por el usuario.
    public void mostrarReporteCalif() {
        System.out.println("\nReporte de calificaciones: ");

        // Si el usuario introdujo por lo menos una calificación...
        if (contadorCalif != 0) {
            // Calcula el promedio de todas las calificaciones introducidas.
            double promedio = (double)total / contadorCalif;

            // Imprime resumen de resultados.
            System.out.printf("El total de las %d calificaciones introducidas es %d\n", contadorCalif, total);
            System.out.printf("El promedio de la clase es %.2f\n", promedio);
            System.out.printf("%s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n",
                    "Numero de estudiantes que recibieron cada calificacion: ",
                    "A: ", aCuenta,         // Muestra el numero de calificaciones A
                    "B: ", bCuenta,         // Muestra el numero de calificaciones B
                    "C: ", cCuenta,         // Muestra el numero de calificaciones C
                    "D: ", dCuenta,         // Muestra el numero de calificaciones D
                    "F: ", fCuenta);        // Muestra el numero de calificaciones F
        }   // Fin del if.
        else {
            System.out.println("No se introdujeron calificaciones");
        }   // Fin del else.
    }   // Fin del método mostrarReporteCalif.
}   // Fin de la clase LibroCalificaciones.
