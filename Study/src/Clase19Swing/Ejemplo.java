package Clase19Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo extends JFrame implements ActionListener{
    JLabel label;
    JButton boton1;
    JButton boton2;
    JPanel panel;

    // Construir ventana.
    public Ejemplo() {
        label = new JLabel("Hola Mundo");
        boton1 = new JButton("1");
        boton2 = new JButton("2");
        panel = new JPanel();
        panel.add(label);
        panel.add(boton1);
        panel.add(boton2);
        add(panel);
        boton1.addActionListener(this);
        boton2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        JButton btnaux = (JButton)event.getSource();
        label.setText("BOTON" + btnaux.getText());
    }

    public static void main(String[] args) {
        Ejemplo  ventana1 = new Ejemplo();
        ventana1.setTitle("Mi primera ventana.");
        ventana1.setSize(500, 500);
        ventana1.setVisible(true);
    }
}
