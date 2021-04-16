package Clase4dibujosgeometricos;

import javax.swing.*;
import java.awt.*;

public class Dibujo extends JPanel {
    public void paintComponent(Graphics g) {
    //public Dibujo(Graphics g) {
        super.paintComponents(g);
        // Dibujar la fachada.
        Poligono p1 = new Poligono();
        int[] coordenadas_x = {150, 220, 220, 150};
        int[] coordenadas_y = {300, 300, 230, 230};
        p1.setNpuntos(4);
        p1.setCoordenadasX(coordenadas_x);
        p1.setCoordenadasY(coordenadas_y);
        g.setColor(Color.red);
        //g.drawPolygon(p1.PrepararPoligono());
        g.fillPolygon(p1.PrepararPoligono());
        // Dibujar el tejado.
        Poligono p2 = new Poligono();
        int[] coor_x = {185, 120, 250};
        int[] coor_y = {180, 230, 230};
        p2.setNpuntos(3);
        p2.setCoordenadasX(coor_x);
        p2.setCoordenadasY(coor_y);
        g.setColor(Color.orange);
        //g.drawPolygon(p2.PrepararPoligono());
        g.fillPolygon(p2.PrepararPoligono());

        // Dibujar el sol.
        Ovalo o1 = new Ovalo();
        o1.setX(300);
        o1.setY(50);
        o1.setAlto(50);
        o1.setAncho(50);
        g.setColor(Color.yellow);
        g.fillOval(o1.getX(), o1.getY(), o1.getAlto(), o1.getAncho());

        // Dibujar el cesped.
        Recta r1 = new Recta();
        r1.setPfinal(new Punto(0, 300));
        r1.setPinicial(new Punto(400, 300));
        g.setColor(Color.green);
        g.drawLine(r1.getPinicial().getPx(), r1.getPinicial().getPy(), r1.getPfinal().getPx(), r1.getPfinal().getPy());

    }
}
