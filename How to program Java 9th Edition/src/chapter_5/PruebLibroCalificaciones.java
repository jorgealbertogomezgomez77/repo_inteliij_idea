
package chapter_5;

/**
 * @author Jorge Alberto Gomez Gomez, January 22 of the 2019, 11:45 PM.
 * Fig. 5.10: LibroCalificaciones.java.
 * Crea un objeto LibroCalificaciones, introduce las calificaciones y muestra un reporte.
 */

public class PruebLibroCalificaciones {

    public static void main(String[] args) {

        // Crea un objeto LibroCalificaciones llamado miLibroCalificaciones.
        // Pasa el nombre del curso al constructor.
        LibroCalificaciones miLibroCalificaciones = new LibroCalificaciones("CS101 Introducción a la programación en JAVA");

        miLibroCalificaciones.mostrarMensaje();         // Muestra un mensaje de bienvenida.
        miLibroCalificaciones.introducirCalif();        // Lee calificaciones del usuario.
        miLibroCalificaciones.mostrarReporteCalif();    // Muestra reporte con base en las calificaciones.
    }   // Fin del Main.
}   // Fin de la clase PruebaLibroCalificaciones.
