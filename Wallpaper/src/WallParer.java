
import javax.swing.*;
import java.awt.*;

public class WallParer extends JFrame {
    double x = 200; // Posición inicial.
    double y = 200;
    double dx = 1;
    double dy = 1; // Desplazamiento.

    public WallParer() {
        new JFrame("Creador de WallParers");
        this.setSize(1600, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void rebota() throws InterruptedException {
        while (true) {
            if (x < 20) { // Choque con el marco izquierdo.
                dx = 1;
            }
            if (x > super.getWidth() - 20) {
                dx = -0.47;
            }
            if (y < 20) { // Choque con el marco superior
                dy = 2;
            }
            if (y > super.getHeight() - 20) {
                dy = -1.23;
            }
            x += dx;
            y += dy;
            Thread.sleep(1);
            repaint();
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int)x, (int)y, 4, 4);
        g.setColor(Color.green);
        g.fillOval((int)(x + 10.2), (int)(y + 10.2), 2, 2);
    }

    public static void main(String[] args) {
        WallParer w = new WallParer();
        try {
            Thread.sleep(1);
            w.rebota();
            Thread.sleep(1);
        }
        catch (Exception e) {

        }
    }
}
