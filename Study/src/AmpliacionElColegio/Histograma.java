
package ampliacionelcolegio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JFrame;

public class Histograma extends JFrame{
    double x = 200;
    double y = 200;
    double dx = 35;
    double dy = 40;
    Aula aula;
    int grados = 180;
    JFrame frame;
    
    public Histograma(Aula aul) throws InterruptedException {
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
        while(it.hasNext()) {
            Thread.sleep(100);
            Alumno a = it.next();
            x += dx;
            pintarRectangulo(this.getGraphics(), a.getNotamedia());
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
    
}
