
package ampliacionelcolegio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JFrame;

public class GraficaLineas extends JFrame{
    double x = 200;
    double y = 200;
    double dx = 35;
    double dy = 40;
    Aula aula;
    int grados = 180;
    Punto p1;
    Punto p2;
    JFrame frame;
    
    public GraficaLineas(Aula aul) throws InterruptedException {
        frame = new JFrame("Grafica");
        aula = aul;
        this.setSize(800, 720);
        Thread.sleep(100);
        this.setVisible(true);
        this.pintarSuelo(this.getGraphics());
        this.recorrerAlumnos();
        this.setResizable(false);
        Thread.sleep(10000);
    }
    
    public void recorrerAlumnos() throws InterruptedException {
        ArrayList<Alumno> lista = new ArrayList<Alumno>(aula.getTablaalumnos().values());
        Iterator<Alumno> it = lista.iterator();
        int contador = 0;
        while(it.hasNext()) {
            Thread.sleep(100);
            Alumno a = it.next();
            x += dx;
            if(contador == 0) { // Primer alumno.
                p1 = new Punto((int)x, (int)a.getNotamedia() * 10);
                this.pintarRectangulo(this.getGraphics(), a.getNotamedia());
                contador ++;
            }
            else {
                p2 = new Punto((int)x, (int)a.getNotamedia() * 10);
                pintarLinea(this.getGraphics(), p1, p2);
                this.pintarRectangulo(this.getGraphics(), a.getNotamedia());
                p1 = p2;
            }
            //pintarRectangulo(this.getGraphics(), a.getNotamedia());
        }
    }

    public void pintarRectangulo(Graphics g, double notamedia) {
        Random ra = new Random();
        Color c = new Color(ra.nextFloat(),ra.nextFloat(), ra.nextFloat());
        double r = Math.toRadians(grados);
        AffineTransform at = new AffineTransform();
        at.rotate(r, 500, 620);
        ((Graphics2D)g).setTransform(at);
        g.setColor(c);
        g.fillRect((int)x, super.getHeight() - 100, 25, (int)(notamedia * 10));
        
    }
    
    public void pintarSuelo(Graphics g) throws InterruptedException {
        Thread.sleep(100);
        g.setColor(Color.red);
        g.drawLine(0, super.getHeight() - 100, super.getWidth(), super.getHeight() - 100);
    }

    public void pintarLinea(Graphics g, Punto p1, Punto p2) {
        double r = Math.toRadians(grados);
        Random ra = new Random();
        AffineTransform at = new AffineTransform();
        at.rotate(r, 500, 620);
        g.setColor(Color.red);
        g.drawLine(p1.getX(), (super.getHeight() - 100) + (p1.getY()), p2.getX(), (super.getHeight() - 100) + (p2.getY()));
    }
    
}
