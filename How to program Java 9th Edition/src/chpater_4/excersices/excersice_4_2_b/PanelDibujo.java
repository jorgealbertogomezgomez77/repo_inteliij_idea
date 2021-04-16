
package chpater_4.excersices.excersice_4_2_b;

import javax.swing.*;
import java.awt.*;

public class PanelDibujo extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int count = 150;
        int count2 = 150;

        for (int i = 0; i <= 150; i++) {

            g.drawLine(0, i * height/150, i * width/150, height);

            g.drawLine(width, i * height/150, count-- * width/150, height);

            g.drawLine(0, count2-- * height/150, i * width/150, 0);

            g.drawLine(i * width/150, 0, width, i * height/150);

            g.drawOval(width/3, height/3,width/3,height/3);
        }
    }
}
