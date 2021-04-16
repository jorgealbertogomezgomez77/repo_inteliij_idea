
package chpater_4.chapt_4___4_14;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jorge Alberto Gomez Gomez, January 18 of the 2019, 12:30 PM.
 * Fig. 4.18: PanelDibujo.java.
 * Uso de drawLine para conectar las esquinas de un panel.
 */

public class PanelDibujo extends JPanel {

    // Dibuja un x desde las esquinas del panel.
    public void paintComponent(Graphics g) {

        // Llama a paintComponent para asegurar que el panel se muestre correctamente.
        super.paintComponent(g);

        int anchura = getWidth();       // Anchura total.
        int altura = getHeight();       // Altura total.

        // Dibuja una linea de la esquina superior izquierda a la esquina inferior derecha.
        g.drawLine(0,0,anchura, altura);

        // Dibuja una linea de la esquina inferior izquierda a la esquina superior derecha.
        g.drawLine(0, altura, anchura, 0);

        //g.drawOval(anchura/2, altura/2,50, 100);
    }   // Fin del método paintComponent.
}   // Fin de la clase PanelDibujo
