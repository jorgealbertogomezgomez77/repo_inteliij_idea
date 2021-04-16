package chpater_4.excersices.excersice_4_1_b;

import javax.swing.*;

public class PruebaPaneDibujo {

    public static void main(String[] args) {

        PanelDibujo panel = new PanelDibujo();

        JFrame edge = new JFrame();

        edge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        edge.add(panel);
        edge.setSize(250,250);
        edge.setVisible(true);
    }
}
