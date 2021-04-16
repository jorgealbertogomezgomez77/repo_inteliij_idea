package Clase22Applets;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class MiPrimerJAplet extends JApplet {
    ArrayList<String> cadena;

    public void init() {
        cadena = new ArrayList<String>();
        cadena.add("Iniciando el JApplet, metodo init");
        JLabel etiqueta1 = new JLabel("Mi primera applet en navegador");
        Panel p = new Panel();
        JButton boton = new JButton("Pulasme");
        boton.addActionListener(new botonEscucha());
        this.add(etiqueta1, BorderLayout.PAGE_START);
        this.add(p);
        this.add(boton, BorderLayout.PAGE_END);
    }

    public void start() {
        cadena.add("Ha empezado -> start()");
    }

    public void stop() {
        cadena.add("Se ha detenido -> stop()");
    }

    public void destroy() {
        cadena.add("Se va a destruir -> destroy()");
    }

    class Panel extends JPanel {
        public Panel() {
            super();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Iterator<String> it = cadena.iterator();
            int j = 0;
            while (it.hasNext()) {
                String resultado = it.next();
                g.drawString(resultado, 0, j);
                j = j + 10;
            }
        }
    } // Acaba la clase Panel.

    class botonEscucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Me has pulsado BIEN", "SubPanel de Boton", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
