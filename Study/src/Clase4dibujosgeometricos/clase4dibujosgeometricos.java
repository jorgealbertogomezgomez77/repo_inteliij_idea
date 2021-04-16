package Clase4dibujosgeometricos;

import javax.swing.*;

public class clase4dibujosgeometricos {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Nuestro Dibujo");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dibujo panelDeDibujo = new Dibujo();
        marco.add(panelDeDibujo);
        marco.setSize(400, 400);
        marco.setVisible(true);
    }
}
