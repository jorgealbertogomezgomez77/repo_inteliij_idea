
package chpater_4.chapt_4___4_14;

import javax.swing.*;

/**
 * @author Jorge Alberto Gomez Gomez, January 18 of the 2019, 12:40 PM.
 * Fig. 4.19: PruebaPanelDibujo.java.
 * Aplicación que muestra un PanelDibujo.
 */

public class PruebaPanelDibujo {

    public static void main(String[] args) {

        // Crea un panel que contiene nuestro dibujo.
        PanelDibujo panel = new PanelDibujo();

        // Crea un nuevo marco para contener el panel.
        JFrame aplicacion = new JFrame();

        // Establece el marco para salir cuando se cierre.
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        aplicacion.add(panel);              // Agrega el panel al marco.
        aplicacion.setSize(250, 250);       // Establece el tamaño del marco.
        aplicacion.setVisible(true);        // Hace que el marco sea visible.
    }   // Fin de main.
}   // Fin de la clase PruebaPanelDibujo
