
package chpater_4.excersices.excersice_4_2_a;

import javax.swing.*;

public class PruebaPanelDibujo {

    public static void main(String[] args) {

        PanelDibujo panel = new PanelDibujo();

        JFrame edge = new JFrame();

        edge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        edge.add(panel);
        edge.setSize(600, 600);
        edge.setVisible(true);
    }
}
