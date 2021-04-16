
package chpater_4.excersices.excersice_4_2_a;

import javax.swing.*;
import java.awt.*;

public class PanelDibujo extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i <= 15; i++) {
            g.drawLine(0,i * height/15, i * width/15,height);
        }
    }
}
