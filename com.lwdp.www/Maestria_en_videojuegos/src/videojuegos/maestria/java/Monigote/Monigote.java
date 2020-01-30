
package videojuegos.maestria.java.Monigote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Monigote extends JFrame implements Runnable, KeyListener {

    Image monigote = this.cargarImagen("monigote_inkscape_2.png");
    int posx = 425;
    int posy = 300;

    BufferedImage bi = new BufferedImage(1000, 600, BufferedImage.TYPE_4BYTE_ABGR);
    Graphics gbi = bi.getGraphics();

    public Image cargarImagen(String nombre) {
        Image imagen = null;
        try {
            imagen = new ImageIcon(this.getClass().getResource(nombre)).getImage();
        }
        catch (Exception e) {
            System.out.println("No se ha podido cargar la imagen.");
        }
        return imagen;
    }

    public void pintarMonigote(Graphics g) {
        g.drawImage(monigote, posx, posy,150, 200, rootPane);
        //repaint();
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void pintarFondo(Graphics g) {
        int i2 = 0;
        for (int i = 0; i <= 135; i++) {
            if (i%2 == 0) {
                i2++;
            }
            Color c = new Color(120 + i, 255, 126 + i2);
            g.setColor(c);
            g.fillRect(0, 6 * i, 1000, 6);
        }
    }

    public void paint(Graphics g) {
        pintarFondo(gbi);
        this.pintarMonigote(gbi);
        g.drawImage(bi, 0, 0, this);
    }

    public Monigote() {
        this.setTitle("Monigote");
        this.setVisible(true);
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public static void main(String[] args) {
        Monigote juego = new Monigote();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char tecla = e.getKeyChar();
        int cantidad = 1;
        System.out.println("He pulsado la tecla --> " + Character.toString(tecla));
        switch (tecla) {
            case 'w': {
                posy -= cantidad;
            } break;
            case 'a': {
                posx -= cantidad;
            } break;
            case 's': {
                posy += cantidad;
            } break;
            case 'd': {
                posx += cantidad;
            } break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
