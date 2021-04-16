
package my_package.chess_table;

import javax.swing.*;

public class ProofDraw {

    public static void main(String[] args) {

        Draw contenido = new Draw();

        JFrame contenedor = new JFrame();

        contenedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contenedor.add(contenido);
        contenedor.setSize(600, 600);
        contenedor.setVisible(true);
    }
}
